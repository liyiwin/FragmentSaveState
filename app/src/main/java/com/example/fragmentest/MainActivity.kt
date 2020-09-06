package com.example.fragmentest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()    {

    val fragmentManager = Manager()

    val fragmenttransAction = TransAction()

    val fragmentView = FragmentViewImp()

   lateinit var  fragmentA : FragmentA

    lateinit var  fragmentB : FragmentB

    lateinit var  fragmentC : FragmentC

    lateinit var  fragmentD : FragmentD



    val fragmentATag = "A"
    val fragmentBTag = "B"
    val fragmentCTag = "C"
    val fragmentDTag = "D"

    var currentFragment = "A"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragments()

        initManager ()

        initTrasAction()

        initFragmentView ()

        setAction ()

        if(savedInstanceState != null){

            val currentFragment = savedInstanceState.getString("currentFragment")
            switch(currentFragment!!)

        }
   }


    override fun onSaveInstanceState(outState: Bundle ) {

        outState.putString("currentFragment" , currentFragment)
        super.onSaveInstanceState(outState )
    }

    fun setAction (){

        button_a.setOnClickListener {

            switch(fragmentATag )
        }

        button_b.setOnClickListener {

            switch(fragmentBTag)
        }

        button_c.setOnClickListener {

            switch(fragmentCTag)

        }

        button_d.setOnClickListener {

            switch(fragmentDTag)

        }

    }



    fun initFragments(){

        fragmentA = FragmentA()

        fragmentB = FragmentB()

        fragmentC = FragmentC()

        fragmentD = FragmentD()


    }

   fun initManager (){

       fragmentManager.setfragmentManager(supportFragmentManager)

   }

  fun initTrasAction(){

      fragmenttransAction.setfragmentManager(supportFragmentManager)

  }


  fun initFragmentView (){

      fragmentView.setfragmentManager(supportFragmentManager)

      fragmentView.settransAction (fragmenttransAction)

      fragmentView.setContainer(R.id.container)

  }

    fun switch (tag:String){

        when(tag){

            "A" -> {

                fragmentView.switchFragment(tag,fragmentA)
                currentFragment =  tag
            }

            "B" -> {

                fragmentView.switchFragment(tag,fragmentB)
                currentFragment =  tag

            }

            "C" -> {

                fragmentView.switchFragment(tag,fragmentC)
                currentFragment =  tag

            }

            "D" -> {

                fragmentView.switchFragment(tag,fragmentD)
                currentFragment =  tag
            }

        }



    }


}
