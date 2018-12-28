package com.example.orpaz.dndcalculator;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import java.util.Random;

public class MainActivity extends Activity {

    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7;
    String dice4, dice6, dice8, dice10, dice12, dice20, dice100, temp;
    int dice4Int, dice6Int, dice8Int, dice10Int, dice12Int, dice20Int, dice100Int;
    int sum;
    Spinner spinner;
    TextView resultTv;
    RatingBar ratingBar;
    MediaPlayer player = null;
    String status_music;
    ImageView volume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = findViewById(R.id.check_box1);
        checkBox2 = findViewById(R.id.check_box2);
        checkBox3 = findViewById(R.id.check_box3);
        checkBox4 = findViewById(R.id.check_box4);
        checkBox5 = findViewById(R.id.check_box5);
        checkBox6 = findViewById(R.id.check_box6);
        checkBox7 = findViewById(R.id.check_box7);

        RadioGroup radioGroup = findViewById(R.id.radio_group);
        RadioButton onBtn = findViewById(R.id.radio_btn_on);
        RadioButton offBtn = findViewById(R.id.radio_btn_off);
        volume = findViewById(R.id.volume_on_img);


        if (onBtn.isChecked())
            playSound();


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_btn_on:
                        playSound();
                        volume.setImageResource(R.drawable.volume_on);
                        break;
                    case R.id.radio_btn_off:
                        stopSound();
                        volume.setImageResource(R.drawable.volume_off);
                        break;
                }
            }
        });

        resultTv = findViewById(R.id.result_view);
        ratingBar = findViewById(R.id.rating_bar);
        final TextView rateTxt = findViewById(R.id.rate_view);
        Button rateBtn = findViewById(R.id.rating_btn);
        rateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float ratingValue = ratingBar.getRating();
                if (ratingValue < 2)
                    rateTxt.setText(R.string.rate_line1_txt);
                else if (ratingValue <= 3)
                    rateTxt.setText(R.string.rate_line2_txt);
                else if (ratingValue <= 4)
                    rateTxt.setText(R.string.rate_line3_txt);
                else
                    rateTxt.setText(R.string.rate_line4_txt);
            }
        });

        final ImageView logo = findViewById(R.id.image_bg1);
        spinner = findViewById(R.id.spinner_id);
        String[] walls = {getString(R.string.logo1_txt), getString(R.string.logo2_txt), getString(R.string.logo3_txt)};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, walls);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        logo.setImageResource(R.drawable.bg1);
                        break;
                    case 1:
                        logo.setImageResource(R.drawable.bg2);
                        break;
                    case 2:
                        logo.setImageResource(R.drawable.bg3);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        float scale = getResources().getDisplayMetrics().density;
        final LinearLayout linear_xml = findViewById(R.id.linear_id);
        LinearLayout.LayoutParams imageLayoutParams = new LinearLayout.LayoutParams((int) (scale * 100), (int) (scale * 100));
        LinearLayout.LayoutParams editTextLayoutParams = new LinearLayout.LayoutParams((int) (scale * 50), (int) (scale * 50));

        final ImageView imageView1 = new ImageView(MainActivity.this);
        final EditText editText1 = new EditText(MainActivity.this);
        imageView1.setLayoutParams(imageLayoutParams);
        imageView1.setImageResource(R.drawable.d4);
        editText1.setLayoutParams(editTextLayoutParams);
        editText1.setHint("1");
        editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
        linear_xml.addView(imageView1);
        linear_xml.addView(editText1);
        imageView1.setVisibility(View.GONE);
        editText1.setVisibility(View.GONE);

        final ImageView imageView2 = new ImageView(MainActivity.this);
        final EditText editText2 = new EditText(MainActivity.this);
        imageView2.setLayoutParams(imageLayoutParams);
        imageView2.setImageResource(R.drawable.d6);
        editText2.setLayoutParams(editTextLayoutParams);
        editText2.setHint("1");
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER);
        linear_xml.addView(imageView2);
        linear_xml.addView(editText2);
        imageView2.setVisibility(View.GONE);
        editText2.setVisibility(View.GONE);

        final ImageView imageView3 = new ImageView(MainActivity.this);
        final EditText editText3 = new EditText(MainActivity.this);
        imageView3.setLayoutParams(imageLayoutParams);
        imageView3.setImageResource(R.drawable.d8);
        editText3.setLayoutParams(editTextLayoutParams);
        editText3.setHint("1");
        editText3.setInputType(InputType.TYPE_CLASS_NUMBER);
        linear_xml.addView(imageView3);
        linear_xml.addView(editText3);
        imageView3.setVisibility(View.GONE);
        editText3.setVisibility(View.GONE);

        final ImageView imageView4 = new ImageView(MainActivity.this);
        final EditText editText4 = new EditText(MainActivity.this);
        imageView4.setLayoutParams(imageLayoutParams);
        imageView4.setImageResource(R.drawable.d10);
        editText4.setLayoutParams(editTextLayoutParams);
        editText4.setHint("1");
        editText4.setInputType(InputType.TYPE_CLASS_NUMBER);
        linear_xml.addView(imageView4);
        linear_xml.addView(editText4);
        imageView4.setVisibility(View.GONE);
        editText4.setVisibility(View.GONE);

        final ImageView imageView5 = new ImageView(MainActivity.this);
        final EditText editText5 = new EditText(MainActivity.this);
        imageView5.setLayoutParams(imageLayoutParams);
        imageView5.setImageResource(R.drawable.d12);
        editText5.setLayoutParams(editTextLayoutParams);
        editText5.setHint("1");
        editText5.setInputType(InputType.TYPE_CLASS_NUMBER);
        linear_xml.addView(imageView5);
        linear_xml.addView(editText5);
        imageView5.setVisibility(View.GONE);
        editText5.setVisibility(View.GONE);

        final ImageView imageView6 = new ImageView(MainActivity.this);
        final EditText editText6 = new EditText(MainActivity.this);
        imageView6.setLayoutParams(imageLayoutParams);
        imageView6.setImageResource(R.drawable.d20);
        editText6.setLayoutParams(editTextLayoutParams);
        editText6.setHint("1");
        editText6.setInputType(InputType.TYPE_CLASS_NUMBER);
        linear_xml.addView(imageView6);
        linear_xml.addView(editText6);
        imageView6.setVisibility(View.GONE);
        editText6.setVisibility(View.GONE);

        final ImageView imageView7 = new ImageView(MainActivity.this);
        final EditText editText7 = new EditText(MainActivity.this);
        imageView7.setLayoutParams(imageLayoutParams);
        imageView7.setImageResource(R.drawable.d100);
        editText7.setLayoutParams(editTextLayoutParams);
        editText7.setHint("1");
        editText7.setInputType(InputType.TYPE_CLASS_NUMBER);
        linear_xml.addView(imageView7);
        linear_xml.addView(editText7);
        imageView7.setVisibility(View.GONE);
        editText7.setVisibility(View.GONE);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    imageView1.setVisibility(View.VISIBLE);
                    editText1.setVisibility(View.VISIBLE);
                } else {
                    imageView1.setVisibility(View.GONE);
                    editText1.setText("");
                    editText1.setVisibility(View.GONE);

                }
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    imageView2.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.VISIBLE);
                } else {
                    imageView2.setVisibility(View.GONE);
                    editText2.setText("");
                    editText2.setVisibility(View.GONE);
                }
            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {
                    imageView3.setVisibility(View.VISIBLE);
                    editText3.setVisibility(View.VISIBLE);
                } else {
                    imageView3.setVisibility(View.GONE);
                    editText3.setText("");
                    editText3.setVisibility(View.GONE);
                }
            }
        });

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {
                    imageView4.setVisibility(View.VISIBLE);
                    editText4.setVisibility(View.VISIBLE);
                } else {
                    imageView4.setVisibility(View.GONE);
                    editText4.setText("");
                    editText4.setVisibility(View.GONE);
                }
            }
        });

        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked()) {
                    imageView5.setVisibility(View.VISIBLE);
                    editText5.setVisibility(View.VISIBLE);
                } else {
                    imageView5.setVisibility(View.GONE);
                    editText5.setText("");
                    editText5.setVisibility(View.GONE);
                }
            }
        });

        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked()) {
                    imageView6.setVisibility(View.VISIBLE);
                    editText6.setVisibility(View.VISIBLE);
                } else {
                    imageView6.setVisibility(View.GONE);
                    editText6.setText("");
                    editText6.setVisibility(View.GONE);
                }
            }
        });

        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox7.isChecked()) {
                    imageView7.setVisibility(View.VISIBLE);
                    editText7.setVisibility(View.VISIBLE);
                } else {
                    imageView7.setVisibility(View.GONE);
                    editText7.setText("");
                    editText7.setVisibility(View.GONE);
                }
            }
        });


        final StringBuilder diceResults = new StringBuilder("");
        final StringBuilder dice4Txt = new StringBuilder("");
        final StringBuilder dice6Txt = new StringBuilder("");
        final StringBuilder dice8Txt = new StringBuilder("");
        final StringBuilder dice10Txt = new StringBuilder("");
        final StringBuilder dice12Txt = new StringBuilder("");
        final StringBuilder dice20Txt = new StringBuilder("");
        final StringBuilder dice100Txt = new StringBuilder("");

        final Random r = new Random();
        Button rollBtn = findViewById(R.id.roll_btn);
        rollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resultTv.setText(R.string.empty_txt);
                dice4Txt.setLength(0);
                dice6Txt.setLength(0);
                dice8Txt.setLength(0);
                dice10Txt.setLength(0);
                dice12Txt.setLength(0);
                dice20Txt.setLength(0);
                dice100Txt.setLength(0);
                diceResults.setLength(0);
                dice4Int = 0;
                dice6Int = 0;
                dice8Int = 0;
                dice12Int = 0;
                dice10Int = 0;
                dice20Int = 0;
                dice100Int = 0;
                sum = 0;

                dice4 = editText1.getText().toString();
                if (dice4.length() != 0)
                    dice4Int = Integer.parseInt(dice4);
                dice6 = editText2.getText().toString();
                if (dice6.length() != 0)
                    dice6Int = Integer.parseInt(dice6);
                dice8 = editText3.getText().toString();
                if (dice8.length() != 0)
                    dice8Int = Integer.parseInt(dice8);
                dice10 = editText4.getText().toString();
                if (dice10.length() != 0)
                    dice10Int = Integer.parseInt(dice10);
                dice12 = editText5.getText().toString();
                if (dice12.length() != 0)
                    dice12Int = Integer.parseInt(dice12);
                dice20 = editText6.getText().toString();
                if (dice20.length() != 0)
                    dice20Int = Integer.parseInt(dice20);
                dice100 = editText7.getText().toString();
                if (dice100.length() != 0)
                    dice100Int = Integer.parseInt(dice100);
                if (!checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked() && !checkBox4.isChecked() &&
                        !checkBox5.isChecked() && !checkBox6.isChecked() && !checkBox7.isChecked())
                    Toast.makeText(MainActivity.this, R.string.not_checked_txt, Toast.LENGTH_SHORT).show();
                else {

                    if (checkBox1.isChecked()) {
                        temp = getString(R.string.d4_txt) + ": ";
                        dice4Txt.append(temp);
                        for (int i = 0; i < dice4Int - 1; i++) {
                            int randomNumber = r.nextInt(4) + 1;
                            sum = sum + randomNumber;
                            temp = randomNumber + ",";
                            dice4Txt.append(temp);
                        }
                        int randomNumber = r.nextInt(4) + 1;
                        sum = sum + randomNumber;
                        temp = randomNumber + "";
                        dice4Txt.append(temp);
                        temp = dice4Txt + "\n";
                        diceResults.append(temp);
                    }

                    if (checkBox2.isChecked()) {
                        temp = getString(R.string.d6_txt) + ": ";
                        dice6Txt.append(temp);
                        for (int i = 0; i < dice6Int - 1; i++) {
                            int randomNumber = r.nextInt(6) + 1;
                            sum = sum + randomNumber;
                            temp = randomNumber + ",";
                            dice6Txt.append(temp);
                        }
                        int randomNumber = r.nextInt(6) + 1;
                        sum = sum + randomNumber;
                        temp = randomNumber + " ";
                        dice6Txt.append(temp);
                        temp = dice6Txt + "\n";
                        diceResults.append(temp);

                    }

                    if (checkBox3.isChecked()) {
                        temp = getString(R.string.d8_txt) + ": ";
                        dice8Txt.append(temp);
                        for (int i = 0; i < dice8Int - 1; i++) {
                            int randomNumber = r.nextInt(8) + 1;
                            sum = sum + randomNumber;
                            temp = randomNumber + ",";
                            dice8Txt.append(temp);
                        }
                        int randomNumber = r.nextInt(8) + 1;
                        sum = sum + randomNumber;
                        temp = randomNumber + " ";
                        dice8Txt.append(temp);
                        temp = dice8Txt + "\n";
                        diceResults.append(temp);
                    }

                    if (checkBox4.isChecked()) {
                        temp = getString(R.string.d10_txt) + ": ";
                        dice10Txt.append(temp);
                        for (int i = 0; i < dice10Int - 1; i++) {
                            int randomNumber = r.nextInt(10) + 1;
                            sum = sum + randomNumber;
                            temp = randomNumber + ",";
                            dice10Txt.append(temp);
                        }
                        int randomNumber = r.nextInt(10) + 1;
                        sum = sum + randomNumber;
                        temp = randomNumber + " ";
                        dice10Txt.append(temp);
                        temp = dice10Txt + "\n";
                        diceResults.append(temp);
                    }

                    if (checkBox5.isChecked()) {
                        temp = getString(R.string.d12_txt) + ": ";
                        dice12Txt.append(temp);
                        for (int i = 0; i < dice12Int - 1; i++) {
                            int randomNumber = r.nextInt(12) + 1;
                            sum = sum + randomNumber;
                            temp = randomNumber + ",";
                            dice12Txt.append(temp);
                        }
                        int randomNumber = r.nextInt(12) + 1;
                        sum = sum + randomNumber;
                        temp = randomNumber + " ";
                        dice12Txt.append(temp);
                        temp = dice12Txt + "\n";
                        diceResults.append(temp);
                    }

                    if (checkBox6.isChecked()) {
                        temp = getString(R.string.d20_txt) + ": ";
                        dice20Txt.append(temp);
                        for (int i = 0; i < dice20Int - 1; i++) {
                            int randomNumber = r.nextInt(20) + 1;
                            sum = sum + randomNumber;
                            temp = randomNumber + ",";
                            dice20Txt.append(temp);
                        }
                        int randomNumber = r.nextInt(20) + 1;
                        sum = sum + randomNumber;
                        temp = randomNumber + " ";
                        dice20Txt.append(temp);
                        temp = dice20Txt + "\n";
                        diceResults.append(temp);
                    }

                    if (checkBox7.isChecked()) {
                        temp = getString(R.string.d100_txt) + ": ";
                        dice100Txt.append(temp);
                        for (int i = 0; i < dice100Int - 1; i++) {
                            int randomNumber = r.nextInt(100) + 1;
                            sum = sum + randomNumber;
                            temp = randomNumber + ",";
                            dice100Txt.append(temp);
                        }
                        int randomNumber = r.nextInt(100) + 1;
                        sum = sum + randomNumber;
                        temp = randomNumber + " ";
                        dice100Txt.append(temp);
                        temp = dice100Txt + "\n";
                        diceResults.append(temp);
                    }

                    temp = "\n" + getString(R.string.score_txt) + " ";
                    temp = diceResults + temp + sum;
                    resultTv.setText(temp);
                }
            }
        });

        Button clearBtn = findViewById(R.id.clear_btn);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked())
                    checkBox1.performClick();
                if (checkBox2.isChecked())
                    checkBox2.performClick();
                if (checkBox3.isChecked())
                    checkBox3.performClick();
                if (checkBox4.isChecked())
                    checkBox4.performClick();
                if (checkBox5.isChecked())
                    checkBox5.performClick();
                if (checkBox6.isChecked())
                    checkBox6.performClick();
                if (checkBox7.isChecked())
                    checkBox7.performClick();
                resultTv.setText(R.string.empty_txt);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null)
            player.release();
        ;
    }

    public void playSound() {
        if (player == null) {
            status_music = "play";
            player = MediaPlayer.create(this, R.raw.spooky);
            player.start();
            player.setLooping(true);
        }
    }

    public void stopSound() {
        if (player != null) {
            status_music = "stop";
            player.release();
            player = null;
        }
    }

}


