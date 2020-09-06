package com.example.fragmentest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentViewImp:FragmentView  {

    val fragmentList= mutableMapOf<String,Fragment>()

    var containerId = 0

    lateinit var transAction: TransAction

    lateinit var fragmentManager: FragmentManager


    fun setfragmentManager (manager: FragmentManager){

        this.fragmentManager = manager

    }



    fun setContainer(containerId:Int){

        this.containerId =containerId

    }

    fun settransAction (transAction:TransAction){

        this.transAction = transAction


    }

    private fun setCurrentFragmentVisiable(currentFragment: Fragment){

        for(i in fragmentList){
            if(i.value == currentFragment)  transAction.showFragment(i.key)
            else transAction.hideFragment(i.key)
        }


    }

    override fun switchFragment(fragmentTag: String , fragment: Fragment) {

        if(!fragmentList.contains(fragmentTag)){
            if(fragmentManager.findFragmentByTag(fragmentTag) != null) transAction.removeFragment(fragmentTag)
            transAction.addNewFragment(containerId,fragment,fragmentTag)
            fragmentList.put(fragmentTag,fragment)
        }
        setCurrentFragmentVisiable(fragment)
    }




}