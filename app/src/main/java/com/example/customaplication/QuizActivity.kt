package com.example.customaplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class QuizActivity : AppCompatActivity(), OnClickListener {

    private var textViewQuestion: TextView? = null
    private var textViewImage: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var textViewProgressBar: TextView? = null
    private var option1: TextView? = null
    private var option2: TextView? = null
    private var option3: TextView? = null
    private var option4: TextView? = null
    private var btnSubmit: Button? = null
    private var questionList: ArrayList<Question>? = null
    private var currentPosition: Int = 1
    private var selectedPosition: Int = 0
    private var userName: String? = null
    private var correctAnswers: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        userName = intent.getStringExtra(Constants.USER_NAME)

        textViewQuestion = findViewById(R.id.textViewQuestion)
        textViewImage = findViewById(R.id.imageView)
        progressBar = findViewById(R.id.progressBar)
        textViewProgressBar = findViewById(R.id.progressTextView)
        option1 = findViewById(R.id.textViewFirstOption)
        option2 = findViewById(R.id.textViewSecondOption)
        option3 = findViewById(R.id.textViewThirdOption)
        option4 = findViewById(R.id.textViewFourthOption)
        btnSubmit = findViewById(R.id.buttonSubmit)

        questionList = Constants.getQuestions()

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        setQuestions()

    }


    private fun setQuestions() {

        defaultOptionsView()
        val question = questionList!![currentPosition - 1]
        textViewQuestion?.text = question.question
        textViewImage?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        textViewProgressBar?.text = "$currentPosition / ${progressBar?.max}"
        option1?.text = question.firstOption
        option2?.text = question.secondOption
        option3?.text = question.thirdOption
        option4?.text = question.fourthOption

    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()

        option1?.let {
            options.add(0, it)
        }
        option2?.let {
            options.add(1, it)
        }
        option3?.let {
            options.add(2, it)
        }
        option4?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_options_view)
        }
    }

    private fun selectedOptionView(text: TextView, selectedOption: Int) {
        defaultOptionsView()
        selectedPosition = selectedOption
        text.setTextColor(Color.parseColor("#7209b7"))
        text.setTypeface(text.typeface, Typeface.BOLD)
        text.background = ContextCompat.getDrawable(this, R.drawable.selected_options_view)
    }

    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.textViewFirstOption -> option1?.let {
                selectedOptionView(it, 1)
            }

            R.id.textViewSecondOption -> {
                option2?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.textViewThirdOption -> {
                option3?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.textViewFourthOption -> {
                option4?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.buttonSubmit -> {

                if (selectedPosition == 0) {
                    currentPosition++

                    when {
                        currentPosition <= questionList!!.size -> {
                            setQuestions()
                            if (currentPosition == questionList!!.size) {
                                btnSubmit?.text = "FINISH"
                            } else {
                                btnSubmit?.text = "SUBMIT"
                            }
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, userName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionList?.size)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = questionList?.get(currentPosition - 1)
                    if (question?.correctAnswer != selectedPosition) {
                        answerView(selectedPosition, R.drawable.wrong_answer_background)
                    } else {
                        correctAnswers++
                    }
                    answerView(question?.correctAnswer, R.drawable.right_answer_background)


                    if (currentPosition == questionList!!.size) {
                        btnSubmit?.text = "PROCEED TO RESULT"
                    } else {

                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                }
                selectedPosition = 0
            }

        }
    }


    private fun answerView(answer: Int?, drawable: Int) {

        when (answer) {

            1 -> {
                option1?.background = ContextCompat.getDrawable(this, drawable)
            }
            2 -> {
                option2?.background = ContextCompat.getDrawable(this, drawable)
            }
            3 -> {
                option3?.background = ContextCompat.getDrawable(this, drawable)
            }
            4 -> {
                option4?.background = ContextCompat.getDrawable(this, drawable)
            }
        }

    }

}



