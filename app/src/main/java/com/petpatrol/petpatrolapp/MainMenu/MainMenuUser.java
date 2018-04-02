package com.petpatrol.petpatrolapp.MainMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.petpatrol.petpatrolapp.Login.MainActivity;
import com.petpatrol.petpatrolapp.R;

import java.util.HashMap;

public class MainMenuUser extends AppCompatActivity {

    private SliderLayout sliderLayout;
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_user);

        sliderLayout = (SliderLayout) findViewById(R.id.slider);
        // Load image dari URL
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Shampoo Kucing", "https://ecs7.tokopedia.net/img/product-1/2015/7/3/392831/392831_4fb31601-6c64-491e-b1ce-4b35175cb3a7.jpg");
        url_maps.put("Shampoo Anti Kutu", "http://cdn.elevenia.co.id/g/4/9/6/8/1/4/15496814_B_V2.jpg");
        url_maps.put("Baju Anjing", "http://3.bp.blogspot.com/-DIZECNtWb0g/VVdRLivuXHI/AAAAAAAAAug/42Gpd_qzQ9Y/s1600/Deep%2BCleansing.jpg");
        url_maps.put("Baju Anjing Lucu", "https://s.kaskus.id/r540x540/images/fjb/2015/06/25/baju_anjing_lucu___lucu__unik__murah_869789_1435236350.jpg");
        // Load Image Dari res/drawable
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Shampoo Kucing",R.drawable.coba);
        file_maps.put("Shampoo Anti Kutu",R.drawable.coba2);
        file_maps.put("Baju Anjing",R.drawable.coba3);
        file_maps.put("Baju Anjing Lucu", R.drawable.coba4);
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set event
        setSingleEvent(mainGrid);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for(int i = 0; i < mainGrid.getChildCount(); i++){
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainMenuUser.this, "Clicked at index " + finalI, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
