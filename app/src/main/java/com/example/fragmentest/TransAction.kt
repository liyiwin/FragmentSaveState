package com.example.fragmentest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentManager

class TransAction() {

    lateinit var fragmentManager:FragmentManager

    fun setfragmentManager (manager: FragmentManager){

        this.fragmentManager = manager

    }

    fun addNewFragment( containerId: Int,fragment:Fragment,tag:String? ){

        val transAction = fragmentManager.beginTransaction()

        if(tag != null)  transAction.add(containerId,fragment,tag)

        else transAction.add(containerId,fragment)

        transAction.addToBackStack("add$fragment")

        transAction.commit()

    }


    fun replaceFragment ( containerId: Int,fragment:Fragment,tag:String? ){

        val transAction = fragmentManager.beginTransaction()

        if(tag != null)  transAction.replace(containerId,fragment,tag)

        else transAction.replace(containerId,fragment)

        transAction.addToBackStack("replace$fragment")

        transAction.commit()


    }


    fun attachFragment (tag: String){

        val attachFragment = fragmentManager.findFragmentByTag(tag)

        val transaction = fragmentManager.beginTransaction()

        if(attachFragment != null){

            transaction.attach(attachFragment)

            transaction.addToBackStack("attach$attachFragment")

            transaction.commit()

        }


    }


    fun detachFragment (tag: String){


        val detachFragment = fragmentManager.findFragmentByTag(tag)

        val transaction = fragmentManager.beginTransaction()

        if(detachFragment != null){

            transaction.detach(detachFragment)

            transaction.addToBackStack("detach$detachFragment")

            transaction.commit()

        }


    }


    fun removeFragment (tag: String){


        val removeFragment = fragmentManager.findFragmentByTag(tag)

        val transaction = fragmentManager.beginTransaction()

        if(removeFragment != null){

            transaction.remove(removeFragment)

            transaction.addToBackStack("remove$removeFragment")

            transaction.commit()

        }


    }

    fun popAbovetransAction (transActionName:String){

        fragmentManager.popBackStack(transActionName,0)

    }

    fun poptransAction(transActionName:String){


        fragmentManager.popBackStack(transActionName,1)


    }


    fun popToptransAction(){

        fragmentManager.popBackStack()

    }


    fun hideFragment (tag: String){

        val hideFragment = fragmentManager.findFragmentByTag(tag)

        val transaction = fragmentManager.beginTransaction()

        if(hideFragment!= null){

            transaction.hide(hideFragment)

            transaction.addToBackStack("hide$hideFragment")

            transaction.commit()

        }


    }


    fun showFragment (tag: String){

        val showFragment = fragmentManager.findFragmentByTag(tag)

        val transaction = fragmentManager.beginTransaction()

        if(showFragment!= null){

            transaction.show(showFragment)

            transaction.addToBackStack("show$showFragment")

            transaction.commit()

        }


    }
}