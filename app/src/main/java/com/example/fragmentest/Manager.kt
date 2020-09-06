package com.example.fragmentest

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class Manager  {

    lateinit var fragmentManager:FragmentManager



    fun setfragmentManager (manager: FragmentManager){

        this.fragmentManager = manager

    }

    fun registerFragmentLifecycleCallback (){

        fragmentManager.registerFragmentLifecycleCallbacks(object:
            FragmentManager.FragmentLifecycleCallbacks(){


            override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {

            }

            override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {

            }

            override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {

            }

            override fun onFragmentDestroyed(fm: FragmentManager, f: Fragment) {

            }


        },false)

    }









}
