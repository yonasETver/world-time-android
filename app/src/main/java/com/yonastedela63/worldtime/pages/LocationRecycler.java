package com.yonastedela63.worldtime.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.yonastedela63.worldtime.R;

import java.util.ArrayList;

public class LocationRecycler extends AppCompatActivity {
    private RecyclerView countryList2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_recycler);

        countryList2 = findViewById(R.id.countryList);

        ArrayList <CountryList> countryLists = new ArrayList<>();

        countryLists.add(new CountryList("Abidjan", "cotdivoire", "Africa/Abidjan"));
        countryLists.add(new CountryList(    "Addis Ababa", "ethiopia", "Africa/Addis_Ababa"));
        countryLists.add(new CountryList("Algiers", "algeria", "Africa/Algiers"));
        countryLists.add(new CountryList(       "Almaty", "kazakhstan", "Asia/Almaty"));
        countryLists.add(new CountryList(       "Amman", "jordan", "Asia/Amman"));
        countryLists.add(new CountryList(       "Andorra", "andorra",  "Europe/Andorra"));
        countryLists.add(new CountryList(  "Araguaina", "brazil", "America/Araguaina"));
        countryLists.add(new CountryList(       "Ashgabat", "turkmenistan", "Asia/Ashgabat"));
        countryLists.add(new CountryList(  "Asuncion","paraguay", "America/Asuncion"));
        countryLists.add(new CountryList(       "Athens", "greece",  "Europe/Athens"));
        countryLists.add(new CountryList(       "Baghdad", "iraq", "Asia/Baghdad"));
        countryLists.add(new CountryList(       "Beirut", "lebanon", "Asia/Beirut"));
        countryLists.add(new CountryList(  "Bahia", "brazil",  "America/Bahia"));
        countryLists.add(new CountryList(       "Bangkok", "thailand", "Asia/Bangkok"));
        countryLists.add(new CountryList(       "Beirut", "lebanon", "Asia/Beirut"));
        countryLists.add(new CountryList(  "Bahia Banderas", "mexico", "America/Bahia_Banderas"));
        countryLists.add(new CountryList(  "Barbados", "barbados", "America/Barbados"));
        countryLists.add(new CountryList(       "Belgrade", "serbia",  "Europe/Belgrade"));
        countryLists.add(new CountryList(       "Berlin", "germany",  "Europe/Berlin"));
        countryLists.add(new CountryList(     "Bermuda", "bermuda", "Atlantic/Bermuda"));
        countryLists.add(new CountryList("Bissau", "ginea_bissau", "Africa/Bissau"));
        countryLists.add(new CountryList(  "Boa Vista", "brazil", "America/Boa_Vista"));
        countryLists.add(new CountryList(  "Bogota", "colombi", "America/Bogota"));
        countryLists.add(new CountryList(       "Brussels", "belgium",  "Europe/Brussels"));
        countryLists.add(new CountryList(       "Budapest", "hungary",  "Europe/Budapest"));
        countryLists.add(new CountryList(  "Buenos Aires",  "argentina", "America/Argentina/Buenos_Aires"));
        countryLists.add(new CountryList( "Cairo",  "egypt", "Africa/Cairo"));
        countryLists.add(new CountryList(   "Cambridge Bay", "canada", "America/Cambridge_Bay"));
        countryLists.add(new CountryList(   "Campo Grande", "belize", "America/Campo_Grande"));
        countryLists.add(new CountryList(   "Cancun", "mexico", "America/Cancun"));
        countryLists.add(new CountryList(   "Caracas", "venezuela", "America/Caracas"));
        countryLists.add(new CountryList( "Casablanca", "moroco", "Africa/Casablanca"));
        countryLists.add(new CountryList(   "Chicago", "usa", "America/Chicago"));
        countryLists.add(new CountryList(   "Costa_Rica",  "costarica", "America/Costa_Rica"));
        countryLists.add(new CountryList(   "Cuiaba", "belize", "America/Cuiaba"));
        countryLists.add(new CountryList(       "Damascus", "syria", "Asia/Damascus"));
        countryLists.add(new CountryList(   "Danmarkshavn",  "denmark", "America/Danmarkshavn"));
        countryLists.add(new CountryList(   "Dawson", "usa", "America/Dawson"));
        countryLists.add(new CountryList(   "Dawson Creek", "usa", "America/Dawson_Creek"));
        countryLists.add(new CountryList(   "Denver", "usa", "America/Denver"));
        countryLists.add(new CountryList(       "Dhaka", "bangladesh", "Asia/Dhaka"));
        countryLists.add(new CountryList(     "Dili", "india",  "Asia/Dili"));
        countryLists.add(new CountryList(       "Dubai", "uae",  "Asia/Dubai"));
        countryLists.add(new CountryList(       "Dublin", "ireland",  "Europe/Dublin"));
        countryLists.add(new CountryList(   "El Salvador", "el_salvador", "America/El_Salvador"));
        countryLists.add(new CountryList(       "Gaza", "gaza",  "Asia/Gaza"));
        countryLists.add(new CountryList(   "Guatemala", "guatemala", "America/Guatemala"));
        countryLists.add(new CountryList(   "Guayaquil", "ecuador", "America/Guayaquil"));
        countryLists.add(new CountryList(   "Guyana", "guyana", "America/Guyana"));
        countryLists.add(new CountryList(   "Havana", "cuba", "America/Havana"));
        countryLists.add(new CountryList(       "Helsinki", "finland",  "Europe/Helsinki"));
        countryLists.add(new CountryList(    "Hong-Kong", "china",  "Asia/Hong_Kong"));
        countryLists.add(new CountryList(       "Istanbul", "turkey",  "Europe/Istanbul"));
        countryLists.add(new CountryList(    "Jakarta", "indonesia",  "Asia/Jakarta"));
        countryLists.add(new CountryList(   "Jamaica", "jamaica", "America/Jamaica"));
        countryLists.add(new CountryList(    "Jerusalem", "israel",  "Asia/Jerusalem"));
        countryLists.add(new CountryList( "Johannesburg", "south_africa", "Africa/Johannesburg"));
        countryLists.add(new CountryList( "Juba",  "south_sudan", "Africa/Juba"));
        countryLists.add(new CountryList(    "Kabul", "afganistan",  "Asia/Kabul"));
        countryLists.add(new CountryList(       "Kaliningrad", "russia",  "Europe/Kaliningrad"));
        countryLists.add(new CountryList( "Khartoum", "sudan", "Africa/Khartoum"));
        countryLists.add(new CountryList(      "Kyiv",  "ukraine", "Europe/Kyiv"));
        countryLists.add(new CountryList(  "Lagos", "nigeria", "Africa/Lagos"));
        countryLists.add(new CountryList(      "Lisbon",  "portugal", "Europe/Lisbon"));
        countryLists.add(new CountryList(   "London",  "london", "Europe/London"));
        countryLists.add(new CountryList(   "Los Angeles", "usa", "America/Los_Angeles"));
        countryLists.add(new CountryList(      "Madrid",  "spain", "Europe/Madrid"));
        countryLists.add(new CountryList(      "Malta",  "spain", "Europe/Malta"));
        countryLists.add(new CountryList(    "Manila", "philippines",  "Asia/Manila"));
        countryLists.add(new CountryList(  "Maputo", "mozambique", "Africa/Maputo"));
        countryLists.add(new CountryList(     "Melbourne", "australia", "Australia/Melbourne"));
        countryLists.add(new CountryList(   "Mexico_City", "mexico", "America/Mexico_City"));
        countryLists.add(new CountryList(      "Minsk",  "belarus", "Europe/Minsk"));
        countryLists.add(new CountryList( "Monrovia", "libiya", "Africa/Monrovia"));
        countryLists.add(new CountryList(      "Moscow",  "russia", "Europe/Moscow"));
        countryLists.add(new CountryList( "Nairobi", "kenya", "Africa/Nairobi"));
        countryLists.add(new CountryList( "Ndjamena",  "chad", "Africa/Ndjamena"));
        countryLists.add(new CountryList(   "New York", "usa", "America/New_York"));
        countryLists.add(new CountryList(   "Panama", "panama", "America/Panama"));
        countryLists.add(new CountryList(      "Paris",  "france", "Europe/Paris"));
        countryLists.add(new CountryList(      "Prague",  "parguay", "Europe/Prague"));
        countryLists.add(new CountryList(   "Puerto Rico", "panama", "America/Puerto_Rico"));
        countryLists.add(new CountryList(       "Pyongyang",  "dprk", "Asia/Pyongyang"));
        countryLists.add(new CountryList(       "Qatar",  "qatar", "Asia/Qatar"));
        countryLists.add(new CountryList(    "Riyadh", "saudi_arabia",  "Asia/Riyadh"));
        countryLists.add(new CountryList(      "Rome",  "italy", "Europe/Rome"));
        countryLists.add(new CountryList(  "San Luis", "argentina", "America/Argentina/San_Luis"));
        countryLists.add(new CountryList(       "Sao Paulo", "brazil", "America/Sao_Paulo"));
        countryLists.add(new CountryList( "Sao Tome", "sao_tome", "Africa/Sao_Tome"));
        countryLists.add(new CountryList(       "Seoul", "south_korea", "Asia/Seoul"));
        countryLists.add(new CountryList(       "Shanghai", "china", "Asia/Shanghai"));
        countryLists.add(new CountryList(       "Sydney", "australia",  "Australia/Sydney"));
        countryLists.add(new CountryList(       "Taipei", "taiwan", "Asia/Taipei"));
        countryLists.add(new CountryList(       "Tehran", "iran", "Asia/Tehran"));
        countryLists.add(new CountryList(     "Tokyo", "japan", "Asia/Tokyo"));
        countryLists.add(new CountryList( "Tripoli", "libiya", "Africa/Tripoli"));
        countryLists.add(new CountryList( "Tunis", "tunisia", "Africa/Tunis"));
        countryLists.add(new CountryList(       "Toronto", "canada", "America/Toronto"));
        countryLists.add(new CountryList(       "Vancouver", "canada", "America/Vancouver"));
        countryLists.add(new CountryList(      "Warsaw",  "poland", "Europe/Warsaw"));
        countryLists.add(new CountryList(  "Windhoek","namibiya", "Africa/Windhoek"));
        countryLists.add(new CountryList(      "Zurich",  "switzerland", "Europe/Zurich"));










        LocationAdapter adapter = new LocationAdapter(this);
        adapter.setCountryLists(countryLists);
        countryList2.setAdapter(adapter);
        countryList2.setLayoutManager(new LinearLayoutManager(this));




    }
}