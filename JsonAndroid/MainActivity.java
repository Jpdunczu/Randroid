package com.example.lalitha.ucbjson;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView myList;
    ArrayList<FeedItem> itemList = new ArrayList<FeedItem>();
    String jsonString = "{\"data\":[{\"id\":\"yOpgR\",\"title\":\"ThisGuyisawsume\\u00a0\",\"description\":null,\"datetime\":1473860111,\"cover\":\"wwzXwIS\",\"cover_width\":1920,\"cover_height\":1080,\"account_url\":\"communistjoe1\",\"account_id\":4538306,\"privacy\":\"hidden\",\"layout\":\"blog\",\"views\":228952,\"link\":\"http:\\/\\/imgur.com\\/a\\/yOpgR\",\"ups\":15429,\"downs\":321,\"points\":15108,\"score\":15108,\"is_album\":true,\"vote\":null,\"favorite\":false,\"nsfw\":false,\"section\":\"\",\"comment_count\":469,\"topic\":\"TheMoreYouKnow\",\"topic_id\":11,\"images_count\":1,\"in_gallery\":true,\"is_ad\":false},\n" +
            "{\"id\":\"CnT2W\",\"title\":\"Whatareyouwaitingfor?\",\"description\":\"AtributetomyfriendPatrick\",\"datetime\":1473849181,\"cover\":\"CXaDAAB\",\"cover_width\":700,\"cover_height\":8475,\"account_url\":\"tiscomics\",\"account_id\":13877793,\"privacy\":\"public\",\"layout\":\"blog\",\"views\":1127981,\"link\":\"http:\\/\\/imgur.com\\/a\\/CnT2W\",\"ups\":20690,\"downs\":391,\"points\":20299,\"score\":20299,\"is_album\":true,\"vote\":null,\"favorite\":false,\"nsfw\":false,\"section\":\"funny\",\"comment_count\":1238,\"topic\":\"Inspiring\",\"topic_id\":72,\"images_count\":7,\"in_gallery\":true,\"is_ad\":false},\n" +
            "{\"id\":\"OMFVy\",\"title\":\"OPDELIVERS!365DaysofMovieQuotesCOMPLETE\",\"description\":\"Itisdone.It'sbeenaninsaneride.ThankstoYOU,whatstartedasasimpleartprojectwentviral.I'vebeeninterviewedbyDailyDot,APlus,andABCNewsinNewYork!Afteroverwhelmingrequests,IstartedanEtsystoretosellprintsofmyworkandnowmyartworkadornswallsallovertheworld!It'sbeenanamazingridethathaschangedmylifeandit'slargelybecauseofYOU,myfellowImgurians.\\n\\nThankyou.Iameternallygrateful.YOUchangedmylife.\\n\\nTL;DR-IdidabigartprojectandImgurmadesureitwasahugesuccess.Thankyou!\",\"datetime\":1473854614,\"cover\":\"nWZBCnN\",\"cover_width\":1944,\"cover_height\":1944,\"account_url\":\"ConflictStar\",\"account_id\":3695936,\"privacy\":\"public\",\"layout\":\"blog\",\"views\":233378,\"link\":\"http:\\/\\/imgur.com\\/a\\/OMFVy\",\"ups\":15336,\"downs\":160,\"points\":15176,\"score\":15176,\"is_album\":true,\"vote\":null,\"favorite\":false,\"nsfw\":false,\"section\":\"Lettering\",\"comment_count\":356,\"topic\":\"StaffPicks\",\"topic_id\":1,\"images_count\":365,\"in_gallery\":true,\"is_ad\":false},\n" +
            "{\"id\":\"BbcxN\",\"title\":\"NobadlyphotoshoppedCeratoday,butpleasetakesometimetomeetCaylum...\",\"description\":null,\"datetime\":1473870714,\"cover\":\"9iNaVeO\",\"cover_width\":960,\"cover_height\":1280,\"account_url\":\"ANewBadlyPhotoshoppedPhotoofMichaelCeraEveryday\",\"account_id\":15363996,\"privacy\":\"hidden\",\"layout\":\"blog\",\"views\":118937,\"link\":\"http:\\/\\/imgur.com\\/a\\/BbcxN\",\"ups\":7025,\"downs\":482,\"points\":6543,\"score\":6543,\"is_album\":true,\"vote\":null,\"favorite\":false,\"nsfw\":false,\"section\":\"\",\"comment_count\":280,\"topic\":\"CurrentEvents\",\"topic_id\":17,\"images_count\":7,\"in_gallery\":true,\"is_ad\":false}]\n}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myList = (ListView) findViewById(R.id.listView);
        populateFromJson(itemList);

    }

    public void populateFromJson(ArrayList<FeedItem> incoming)
    {
        try {
            JSONObject root = new JSONObject(jsonString);
            JSONArray myarr = root.getJSONArray("data");
            for (int i = 0; i < myarr.length(); i++) {
                FeedItem kl = new FeedItem();
                String id = ((JSONObject) myarr.get(i)).getString("title");
                String link = ((JSONObject) myarr.get(i)).getString("link");
                kl.setTitle(id);
                kl.setThumbnail(link);
                incoming.add(kl);
            }
        } catch (Exception w) { w.printStackTrace();}

        for (int i = 0; i< incoming.size() ; i++)
            Log.d("LALITHA", incoming.get(i).getLink() + "  " + incoming.get(i).getTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
