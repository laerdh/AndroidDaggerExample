package com.ledahl.androiddaggertest.injector.component;

import com.ledahl.androiddaggertest.MainActivity;
import com.ledahl.androiddaggertest.injector.module.RestServiceModule;
import com.ledahl.androiddaggertest.service.RestService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        RestServiceModule.class
})
public interface AppComponent {

    RestService provideRestService();

    void inject(MainActivity activity);

}
