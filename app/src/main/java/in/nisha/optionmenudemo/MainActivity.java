package in.nisha.optionmenudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    public final int MENU_SETTINGS =1, MENU_PHONE_SETTINGS =2,MENU_BLUETOOTH_SETTING =3,MENU_DISPLAY =4;
    CheckBox enableSetting;
    int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        makeToast("onCreate - MainActivity");
    }

    private void initViews()
    {

        enableSetting=findViewById(R.id.enableSettings);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu subMenu = menu.addSubMenu(1,MENU_SETTINGS,1,"Setting");
        subMenu.add(1,MENU_PHONE_SETTINGS,2,"phone");
        subMenu.add(1,MENU_DISPLAY,3,"Display");
        subMenu.add(1,MENU_BLUETOOTH_SETTING,4,"Bluetooth");
        MenuItem menuItemHelp = menu.add(2,5,5,"Help");
        MenuItem menuItemAbout = menu.add(3,6,6,"About");
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        itemId = item.getItemId();
        switch (itemId)
        {
            case MENU_SETTINGS:
                makeToast("Setting");
                break;

            case MENU_PHONE_SETTINGS:
                makeToast(" Phone Setting");
                break;

            case MENU_BLUETOOTH_SETTING:
                makeToast(" Bluetooth Setting");
                break;

            case MENU_DISPLAY:
                makeToast(" Display Setting");
                break;

            case 5:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                makeToast("Help");
                break;

            case 6:
                makeToast("About");
                break;
        }
        return true;


    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        makeToast("on Prepare Options");

        menu.setGroupEnabled(1,enableSetting.isChecked());
        menu.findItem(MENU_BLUETOOTH_SETTING).setVisible(true);
        menu.setGroupVisible(1,true);
        return true;

    }


    private  void makeToast(String text)
    {

        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

}
