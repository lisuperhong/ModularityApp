package com.lisuperhong.modularityapp.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.company.commonbusiness.base.activity.BaseActivity;
import com.lisuperhong.kaiyanmodule.ui.fragment.KaiyanMainFragment;
import com.lisuperhong.modularityapp.R;
import com.lisuperhong.modularityapp.app.Constants;
import com.lisuperhong.zhihumodule.ui.fragment.ZhihuMainFragment;


public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
	NavigationView navigationView;
	Toolbar toolbar;

	private KaiyanMainFragment kaiyanMainFragment;
	private ZhihuMainFragment zhihuMainFragment;
	private FragmentManager fragmentManager;
	private MenuItem lastMenuItem;
	private String currentFragment = Constants.TYPE_KAIYAN;

	@Override
	protected int getLayoutResId() {
		return R.layout.activity_main;
	}

	@Override
	protected void initView() {
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		navigationView = (NavigationView) findViewById(R.id.nav_view);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setToolBar(toolbar, "开眼视频");
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
				R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawerLayout.addDrawerListener(toggle);
		toggle.syncState();

		navigationView.setNavigationItemSelectedListener(this);
	}

    @Override
	protected void initData(Bundle savedInstanceState) {
        fragmentManager = getSupportFragmentManager();
        lastMenuItem = navigationView.getMenu().findItem(R.id.drawer_menu_kaiyan);

        if (savedInstanceState != null) {
            currentFragment = savedInstanceState.getString("currentFragment");
            kaiyanMainFragment = (KaiyanMainFragment) fragmentManager.findFragmentByTag(Constants.TYPE_KAIYAN);
            zhihuMainFragment = (ZhihuMainFragment) fragmentManager.findFragmentByTag(Constants.TYPE_ZHIHU);
            lastMenuItem = navigationView.getMenu().findItem(getCurrentItem(currentFragment));
            setCurrentFragment(currentFragment);
        } else {
            setCurrentFragment(currentFragment);
        }
	}

    @Override
    public void onBackPressed() {
		super.onBackPressed();
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String selectedType = currentFragment;

        switch (item.getItemId()) {
            case R.id.drawer_menu_kaiyan:
                selectedType = Constants.TYPE_KAIYAN;
                break;

            case R.id.drawer_menu_zhihu:
                selectedType = Constants.TYPE_ZHIHU;
                break;

            case R.id.drawer_menu_wechat:
                selectedType = Constants.TYPE_WECHAT;
                break;

            case R.id.drawer_menu_gank:
                selectedType = Constants.TYPE_GANK;
                break;

            case R.id.drawer_menu_vtex:
                selectedType = Constants.TYPE_VTEX;
                break;

            case R.id.drawer_menu_like:
                break;

            case R.id.action_settings:
                break;

            case R.id.drawer_menu_about:
                break;

            default:
                break;
        }

        if (lastMenuItem != null) {
			lastMenuItem.setChecked(false);
		}
		lastMenuItem = item;
		item.setChecked(true);
		setCurrentFragment(selectedType);

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("currentFragment", currentFragment);
		super.onSaveInstanceState(outState);
	}

	private void setCurrentFragment(String type) {
		if (!type.equals(currentFragment) || type.equals(Constants.TYPE_KAIYAN)) {
			currentFragment = type;
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			switch (type) {
				case Constants.TYPE_KAIYAN:
					toolbar.setTitle(lastMenuItem.getTitle().toString());
					if (kaiyanMainFragment == null) {
                        kaiyanMainFragment = new KaiyanMainFragment();
					}
					transaction.replace(R.id.content_container, kaiyanMainFragment, Constants.TYPE_KAIYAN);
					break;

				case Constants.TYPE_ZHIHU:
					toolbar.setTitle(lastMenuItem.getTitle().toString());
					if (zhihuMainFragment == null) {
                        zhihuMainFragment = new ZhihuMainFragment();
					}
					transaction.replace(R.id.content_container, zhihuMainFragment, Constants.TYPE_ZHIHU);
					break;

				default:
					break;
			}

			invalidateOptionsMenu();
			transaction.commit();
			drawerLayout.closeDrawer(GravityCompat.START);
		} else {
			//如果在当前页
			drawerLayout.closeDrawer(GravityCompat.START);
		}
	}

	private int getCurrentItem(String type) {
		switch (type) {
			case Constants.TYPE_KAIYAN:
				return R.id.drawer_menu_kaiyan;

			case Constants.TYPE_ZHIHU:
				return R.id.drawer_menu_kaiyan;

			case Constants.TYPE_GANK:
				return R.id.drawer_menu_gank;

			case Constants.TYPE_WECHAT:
				return R.id.drawer_menu_wechat;

			case Constants.TYPE_VTEX:
				return R.id.drawer_menu_vtex;
		}

		return R.id.drawer_menu_kaiyan;
	}
}
