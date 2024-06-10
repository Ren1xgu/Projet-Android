package com.example.country.util;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;


import java.util.ArrayList;

import okhttp3.Call;

public class Country {
    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cname='" + cname + '\'' +
                ", ename='" + ename + '\'' +
                ", capital='" + capital + '\'' +
                ", nationalanthem='" + nationalanthem + '\'' +
                ", currency='" + currency + '\'' +
                ", code=" + code +
                ", language='" + language + '\'' +
                ", area='" + area + '\'' +
                ", timezone='" + timezone + '\'' +
                ", gdp='" + gdp + '\'' +
                ", avggdp='" + avggdp + '\'' +
                ", areacode=" + areacode +
                ", domain='" + domain + '\'' +
                ", continent='" + continent + '\'' +
                ", waterrate='" + waterrate + '\'' +
                ", mainreligion='" + mainreligion + '\'' +
                ", maincity='" + maincity + '\'' +
                ", nationalday='" + nationalday + '\'' +
                ", political='" + political + '\'' +
                ", leader='" + leader + '\'' +
                ", population='" + population + '\'' +
                ", populationdensity='" + populationdensity + '\'' +
                ", mainethnic='" + mainethnic + '\'' +
                ", roadaccess='" + roadaccess + '\'' +
                ", mainuniversity=" + mainuniversity +
                ", nationalflag='" + nationalflag + '\'' +
                ", humanindex=" + humanindex +
                ", largestcity='" + largestcity + '\'' +
                ", nationalflower=" + nationalflower +
                ", geoposition=" + geoposition +
                ", foreignname=" + foreignname +
                ", nationalmotto=" + nationalmotto +
                ", govresidence=" + govresidence +
                ", climate=" + climate +
                ", iscountry=" + iscountry +
                ", initial='" + initial + '\'' +
                ", bookmark=" + bookmark +
                '}';
    }

    public Country() {
    }

    public Country(String name, String nationalflag) {
        this.name = name;
        this.nationalflag = nationalflag;
    }

    /**
     * id : 1
     * name : 阿布哈兹
     * cname : 阿布哈兹共和国
     * ename : Abkhazia
     * capital : 苏呼米
     * nationalanthem : 《胜利》（Aiaaira）
     * currency : 俄罗斯卢布、阿布哈兹阿沙
     * code : null
     * language : 阿布哈兹语、俄语
     * area : 8860平方公里
     * timezone : 东3区
     * gdp : 5亿美元（2014年）
     * avggdp : 2059美元(2014年)
     * areacode : null
     * domain : ABH
     * continent : 欧洲
     * waterrate : 忽略不计
     * mainreligion : 伊斯兰教（逊尼派），东正教
     * maincity : 加格拉，古尔里普希，古道塔
     * nationalday : 1992年7月23日
     * political : 共和制
     * leader : 总统：劳尔·哈吉姆巴；总理：别斯兰·布特巴
     * population : 242,000（2016年）
     * populationdensity : 28人/平方公里（2012年）
     * mainethnic : 阿布哈兹人、俄罗斯人
     * roadaccess : 靠右驾驶
     * mainuniversity : null
     * nationalflag : https://api.jisuapi.com/country/upload/nationalflag/1.jpg
     * humanindex : null
     * largestcity : 苏呼米
     * nationalflower : null
     * geoposition : null
     * foreignname : null
     * nationalmotto : null
     * govresidence : null
     * climate : null
     * iscountry : 1
     * initial : A
     */

    private int id;
    private String name;
    private String cname;
    private String ename;
    private String capital="";
    private String nationalanthem;
    private String currency;
    private Object code;
    private String language;
    private String area;
    private String timezone;
    private String gdp;
    private String avggdp;
    private Object areacode;
    private String domain;
    private String continent;
    private String waterrate;
    private String mainreligion;
    private String maincity;
    private String nationalday;
    private String political;
    private String leader;
    private String population;
    private String populationdensity;
    private String mainethnic;
    private String roadaccess;
    private Object mainuniversity;
    private String nationalflag;
    private Object humanindex;
    private String largestcity;
    private Object nationalflower;
    private Object geoposition;
    private Object foreignname;
    private Object nationalmotto;
    private Object govresidence;
    private Object climate;
    private int iscountry;
    private String initial;
    private int bookmark;

    public int getBookmark() {
        return bookmark;
    }

    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getCapital() {
        if (TextUtils.isEmpty(capital))return "";
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getNationalanthem() {
        return nationalanthem;
    }

    public void setNationalanthem(String nationalanthem) {
        this.nationalanthem = nationalanthem;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getGdp() {
        return gdp;
    }

    public void setGdp(String gdp) {
        this.gdp = gdp;
    }

    public String getAvggdp() {
        return avggdp;
    }

    public void setAvggdp(String avggdp) {
        this.avggdp = avggdp;
    }

    public Object getAreacode() {
        return areacode;
    }

    public void setAreacode(Object areacode) {
        this.areacode = areacode;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getWaterrate() {
        return waterrate;
    }

    public void setWaterrate(String waterrate) {
        this.waterrate = waterrate;
    }

    public String getMainreligion() {
        return mainreligion;
    }

    public void setMainreligion(String mainreligion) {
        this.mainreligion = mainreligion;
    }

    public String getMaincity() {
        return maincity;
    }

    public void setMaincity(String maincity) {
        this.maincity = maincity;
    }

    public String getNationalday() {
        return nationalday;
    }

    public void setNationalday(String nationalday) {
        this.nationalday = nationalday;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getPopulationdensity() {
        return populationdensity;
    }

    public void setPopulationdensity(String populationdensity) {
        this.populationdensity = populationdensity;
    }

    public String getMainethnic() {
        return mainethnic;
    }

    public void setMainethnic(String mainethnic) {
        this.mainethnic = mainethnic;
    }

    public String getRoadaccess() {
        return roadaccess;
    }

    public void setRoadaccess(String roadaccess) {
        this.roadaccess = roadaccess;
    }

    public Object getMainuniversity() {
        return mainuniversity;
    }

    public void setMainuniversity(Object mainuniversity) {
        this.mainuniversity = mainuniversity;
    }

    public String getNationalflag() {
        return nationalflag;
    }

    public void setNationalflag(String nationalflag) {
        this.nationalflag = nationalflag;
    }

    public Object getHumanindex() {
        return humanindex;
    }

    public void setHumanindex(Object humanindex) {
        this.humanindex = humanindex;
    }

    public String getLargestcity() {
        return largestcity;
    }

    public void setLargestcity(String largestcity) {
        this.largestcity = largestcity;
    }

    public Object getNationalflower() {
        return nationalflower;
    }

    public void setNationalflower(Object nationalflower) {
        this.nationalflower = nationalflower;
    }

    public Object getGeoposition() {
        return geoposition;
    }

    public void setGeoposition(Object geoposition) {
        this.geoposition = geoposition;
    }

    public Object getForeignname() {
        return foreignname;
    }

    public void setForeignname(Object foreignname) {
        this.foreignname = foreignname;
    }

    public Object getNationalmotto() {
        return nationalmotto;
    }

    public void setNationalmotto(Object nationalmotto) {
        this.nationalmotto = nationalmotto;
    }

    public Object getGovresidence() {
        return govresidence;
    }

    public void setGovresidence(Object govresidence) {
        this.govresidence = govresidence;
    }

    public Object getClimate() {
        return climate;
    }

    public void setClimate(Object climate) {
        this.climate = climate;
    }

    public int getIscountry() {
        return iscountry;
    }

    public void setIscountry(int iscountry) {
        this.iscountry = iscountry;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public static ArrayList<Country> getCountry(DatabaseHelper databaseHelper,CountryRvAdapter adapter,ArrayList<Country> allList) {

        ArrayList<Country> allCountries = databaseHelper.getAllCountries();
        if (allCountries!=null&&allCountries.size()>0){
            adapter.setList(allCountries);
            allList.addAll(allCountries);
            return allCountries;
        }
        OkHttpUtils.get().url("https://restcountries.com/v3.1/all").build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("TAG11111111",response);
                        BaseResponse<ArrayList<Country>> baseResponse = JSONObject.parseObject(response, new TypeReference<BaseResponse<ArrayList<Country>>>() {});
                        if (baseResponse.getStatus()==0){
                            ArrayList<Country> result = baseResponse.getResult();
                            adapter.setList(result);
                            allList.addAll(result);
                            for (Country country:result) {
                                try {
                                    databaseHelper.insertCountry(country);
                                }catch (Exception e){
                                }
                            }
                        }
                    }
                });

        return allCountries;
    }
}
