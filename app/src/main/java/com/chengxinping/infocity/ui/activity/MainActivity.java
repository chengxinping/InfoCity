package com.chengxinping.infocity.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import com.chengxinping.infocity.R;
import com.chengxinping.infocity.ui.base.BaseActivity;
import com.chengxinping.infocity.ui.fragment.BusFragment;
import com.chengxinping.infocity.ui.fragment.NewsFragment;
import com.chengxinping.infocity.ui.fragment.ServiceFragment;

import butterknife.BindView;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private long exitTime = 0;

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        setFragment(new NewsFragment());
    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            setFragment(new NewsFragment());
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_bus) {
            setFragment(new BusFragment());
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_service) {
            setFragment(new ServiceFragment());
            drawer.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_share) {
            ShareSDK.initSDK(this);
            OnekeyShare oks = new OnekeyShare();
            oks.disableSSOWhenAuthorize();
            oks.setTitle(getString(R.string.app_name));
            oks.setTitleUrl("http://www.xpcheng.cn");
            oks.setText("我发现了一个很好玩的APP哟~");
            oks.setSite(getString(R.string.app_name));
            oks.setSiteUrl("http://www.xpcheng.cn");
            oks.setUrl("http://www.xpcheng.cn");
            oks.setImageUrl("http://www.xpcheng.cn/wp-content/uploads/2017/04/Jay.jpg");
            oks.show(this);
        } else if (id == R.id.nav_about) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("智慧城市")
                    .setMessage("  离开书店的时候，我留下了一把伞，希望拧着它回家的人，是你。")
                    .setPositiveButton("确定", null)
                    .show();
        }
        return true;
    }

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    public void setFabVisibility(boolean tag) {
        if (tag) {
            fab.setVisibility(View.VISIBLE);
        } else {
            fab.setVisibility(View.GONE);
        }
    }

    public void setFabImg(int res) {
        fab.setImageResource(res);
    }

    public void setFabOnClickListener(View.OnClickListener listener) {
        fab.setOnClickListener(listener);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else if (System.currentTimeMillis() - exitTime > 2000) {
                Snackbar snackbar = Snackbar.make(fab, "再按一次退出程序", Snackbar.LENGTH_SHORT);
//                snackbar.setAction("确定", v -> snackbar.dismiss());
//                snackbar.setActionTextColor(getResources().getColor(R.color.refresh_color));
                snackbar.getView().setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                snackbar.show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
