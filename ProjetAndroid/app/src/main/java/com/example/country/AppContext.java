
package com.example.country;

import android.app.Application;
import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Application
 *
 */
public class AppContext extends Application {
	private static Context context;

	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();

		
		CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
		/*Initial OkHttpClient*/
		HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
		logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(40000L, TimeUnit.MILLISECONDS)
                .readTimeout(40000L, TimeUnit.MILLISECONDS)
				.addNetworkInterceptor(logInterceptor)
                .cookieJar(cookieJar)
                //其他配置
               .build();
		OkHttpUtils.initClient(okHttpClient);

	}

}
