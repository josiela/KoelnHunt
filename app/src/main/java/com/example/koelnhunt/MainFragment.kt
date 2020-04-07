package com.example.koelnhunt

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.koelnhunt.models.CardStructure
import com.example.koelnhunt.models.DataSource
import com.example.koelnhunt.models.HintDataSource
import com.example.koelnhunt.models.QuestionDataSource
import kotlinx.android.synthetic.main.card_frage.view.*
import kotlinx.android.synthetic.main.card_hinweis.view.*
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment(), RecyclerAdapter.OnCardClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // Dialog PopUp
    @SuppressLint("InflateParams")
    fun showDialog(position: Int) {
        val mHinweisView = LayoutInflater.from(activity).inflate(R.layout.card_hinweis, null)

        val mBuilder = AlertDialog.Builder(activity)
            .setView(mHinweisView)

        val mHinweisDialog = mBuilder.show()

        val hintData = HintDataSource.createHintSet()[position]
        mHinweisView.Hinweis.text = hintData

        mHinweisView.CloseButtonHint.setOnClickListener{
            mHinweisDialog.dismiss()
        }

        mHinweisView.FoundButton.setOnClickListener{
            val mFrageView = LayoutInflater.from(activity).inflate(R.layout.card_frage, null)

            val questionData = QuestionDataSource.createQuestionSet()[position]
            mFrageView.Question.text = questionData.question

            mFrageView.ApplyButton.setOnClickListener{
                if (mFrageView.QuestionField.text.toString().toLowerCase(Locale.ROOT) == questionData.answer.toLowerCase()) {
                    handleCorrectAnswer()
                } else {
                    handleWrongAnswer(mFrageView.QuestionField, mFrageView.ApplyButton)
                }

            }

            mHinweisDialog.setContentView(mFrageView)
            mFrageView.CloseButtonFrage.setOnClickListener{
                mHinweisDialog.dismiss()
            }
        }
    }

    //Recyclerview
    private lateinit var blogAdapter: RecyclerAdapter

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            val topSpacingDecoration = TopSpacingItemDecoration(40)
            addItemDecoration(topSpacingDecoration)
            blogAdapter = RecyclerAdapter(this@MainFragment)
            adapter = blogAdapter
        }
    }

    private fun addDataSet() {
        val data = DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        /* val button = view.findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            showDialog()
        } */
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()
        addDataSet()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment MainFragment.
         */
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
            }
    }

    //Recyclerview OnClickListener
    override fun onItemClick(items: CardStructure, position: Int) {
        //TODO if position (=Listnumber) < aktueller Stand: rufe showDialog auf, ansonsten nicht
        showDialog(position)
    }

    private fun handleCorrectAnswer() {
        println("Yay")
    }

    private fun handleWrongAnswer(textField: EditText, applyButton: Button) {
        val animation = AnimationUtils.loadAnimation(context, R.anim.shake)
        applyButton.startAnimation(animation)
        textField.text.clear()
        textField.hint = "Versuch\'s noch mal!"
    }
}
