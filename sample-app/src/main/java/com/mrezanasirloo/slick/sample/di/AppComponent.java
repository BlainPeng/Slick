package com.mrezanasirloo.slick.sample.di;


import com.mrezanasirloo.slick.sample.activity.dagger.DaggerModule;
import com.mrezanasirloo.slick.sample.activity.dagger.ExampleActivity;
import com.mrezanasirloo.slick.sample.conductor.dagger.ExampleController;
import com.mrezanasirloo.slick.sample.cutstomview.dagger.DaggerCustomView;
import com.mrezanasirloo.slick.sample.fragment.dagger.DaggerFragment;
import com.mrezanasirloo.slick.sample.fragment.dagger.delegate.DelegateDaggerFragment;
import com.mrezanasirloo.slick.sample.fragmentsupport.dagger.DaggerFragmentSupport;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

/**
 * @author : M.Reza.Nasirloo@gmail.com
 *         Created on: 2016-11-01
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    DaggerComponent add(DaggerModule mainModule);

    @Subcomponent(modules = DaggerModule.class)
    interface DaggerComponent {
        void inject(ExampleActivity activity);

        void inject(ExampleController controller);

        void inject(DaggerFragment fragment);

        void inject(DelegateDaggerFragment delegateDaggerSlickFragment);

        void inject(DaggerFragmentSupport daggerFragment);

        void inject(DaggerCustomView daggerCustomView);
    }

}