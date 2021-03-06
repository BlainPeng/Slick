/*
 * Copyright 2018. M. Reza Nasirloo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mrezanasirloo.slick.sample.di;


import com.mrezanasirloo.slick.sample.activity.dagger.ActivitySimpleDagger;
import com.mrezanasirloo.slick.sample.activity.dagger.DaggerModule;
import com.mrezanasirloo.slick.sample.conductor.dagger.ControllerDagger;
import com.mrezanasirloo.slick.sample.cutstomview.dagger.CustomViewDagger;
import com.mrezanasirloo.slick.sample.fragment.dagger.FragmentDagger;
import com.mrezanasirloo.slick.sample.fragment.dagger.delegate.FragmentDelegateDagger;
import com.mrezanasirloo.slick.sample.fragmentsupport.dagger.FragmentSupportDagger;

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
        void inject(ActivitySimpleDagger activity);

        void inject(ControllerDagger controller);

        void inject(FragmentDagger fragment);

        void inject(FragmentDelegateDagger delegateDaggerSlickFragment);

        void inject(FragmentSupportDagger daggerFragment);

        void inject(CustomViewDagger daggerCustomView);
    }

}
