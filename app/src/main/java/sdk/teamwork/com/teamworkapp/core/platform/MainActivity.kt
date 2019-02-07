package sdk.teamwork.com.teamworkapp.core.platform

import android.os.Bundle
import android.view.Menu
import sdk.teamwork.com.teamworkapp.R
import sdk.teamwork.com.teamworkapp.core.features.projects.ProjectsFragment

class MainActivity : BaseActivity(){

  override fun fragment(): BaseFragment = ProjectsFragment.newInstance()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onBackPressed() {
    if (supportFragmentManager.backStackEntryCount == 0) {
      finish()
    } else {
      super.onBackPressed()
    }
  }
}
