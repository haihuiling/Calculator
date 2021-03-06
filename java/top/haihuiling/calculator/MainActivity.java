package top.haihuiling.calculator;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author haihuiling
 * @date 2017-02-26
 */
public class MainActivity extends AppCompatActivity {
    ArrayList<String> inputs = new ArrayList<>();
    ArrayList<String> temp = new ArrayList<>();
    ArrayList<String> temp2 = new ArrayList<>();
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnC;
    Button btnDiv;
    Button btnEqu;
    Button btnSub;
    Button btnAdd;
    Button btnMul;
    Button btndot;
    Button btnpi;
    Button btnsqrt;
    Button btncube;
    TextView result;
    Boolean isPressEqu = false;
    Boolean isPressDiv = false;
    Boolean isPressMul = false;
    Boolean isPressSub = false;
    Boolean isPressPlus = false;
    String lastResult = "";
    Boolean isInvalid = false;
    Boolean isHaveFloat = false;//是否输入了浮点数
    int floatNum = 0;//输入浮点数的位数
    Boolean isPressSqrt = false;
    Boolean isPressCube = false;
    Boolean isSoundOpen = true;
    Boolean isPressPi =false;
    private MediaPlayer music = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置主题 白天设置2 晚上设置1
        Date today = new Date();
        if (today.getHours() >= 6 && today.getHours() <= 17) {
            setTheme(R.style.AppTheme2);
        } else {
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.activity_main);
        //初始化
        initButton();
        //给按钮添加点击事件
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSoundOpen)
                    playMusic(R.raw.sweet_zero);
                result.setText(result.getText() + "0");
                doNumInput("0");
                isPressDiv = false;
                isPressPlus = false;
                isPressSub = false;
                isPressMul = false;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSoundOpen)
                    playMusic(R.raw.sweet_one);
                result.setText(result.getText() + "1");
                doNumInput("1");
                isPressDiv = false;
                isPressPlus = false;
                isPressSub = false;
                isPressMul = false;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSoundOpen)
                    playMusic(R.raw.sweet_two);
                result.setText(result.getText() + "2");
                doNumInput("2");
                isPressDiv = false;
                isPressPlus = false;
                isPressSub = false;
                isPressMul = false;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSoundOpen)
                    playMusic(R.raw.sweet_three);
                result.setText(result.getText() + "3");
                doNumInput("3");
                isPressDiv = false;
                isPressPlus = false;
                isPressSub = false;
                isPressMul = false;
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSoundOpen)
                    playMusic(R.raw.sweet_four);
                result.setText(result.getText() + "4");
                doNumInput("4");
                isPressDiv = false;
                isPressPlus = false;
                isPressSub = false;
                isPressMul = false;
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSoundOpen)
                    playMusic(R.raw.sweet_five);
                result.setText(result.getText() + "5");
                doNumInput("5");
                isPressDiv = false;
                isPressPlus = false;
                isPressSub = false;
                isPressMul = false;
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSoundOpen)
                    playMusic(R.raw.sweet_six);
                result.setText(result.getText() + "6");
                doNumInput("6");
                isPressDiv = false;
                isPressPlus = false;
                isPressSub = false;
                isPressMul = false;
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSoundOpen)
                    playMusic(R.raw.sweet_seven);
                result.setText(result.getText() + "7");
                doNumInput("7");
                isPressDiv = false;
                isPressPlus = false;
                isPressSub = false;
                isPressMul = false;
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSoundOpen)
                    playMusic(R.raw.sweet_eight);
                result.setText(result.getText() + "8");
                doNumInput("8");
                isPressDiv = false;
                isPressPlus = false;
                isPressSub = false;
                isPressMul = false;
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSoundOpen)
                    playMusic(R.raw.sweet_nine);
                result.setText(result.getText() + "9");
                doNumInput("9");
                isPressDiv = false;
                isPressPlus = false;
                isPressSub = false;
                isPressMul = false;
            }
        });
        //处理小数点
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //第一位不能输入小数点
                if (!isHaveFloat && !isPressEqu && inputs.size() != 0&&!isPressPi) {
                    if (isSoundOpen)
                        playMusic(R.raw.sweet_dot);
                    result.setText(result.getText() + ".");
//                    isPressDiv = false;
//                    isPressPlus = false;
//                    isPressSub = false;
//                    isPressMul = false;
                    isHaveFloat = true;
                    floatNum = 1;
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInvalid) {
                    result.setText("");
                    isInvalid = false;
                }
                if (isPressEqu) {
                    inputs.add(lastResult);
                    isPressEqu = false;
                    result.setText("Ans");
                }
                if (!isPressMul && !isPressDiv && !isPressSub && !isPressPlus && !isPressCube && !isPressSqrt) {
                    if (isSoundOpen)
                        playMusic(R.raw.sweet_div);
                    inputs.add("/");
                    result.setText(result.getText() + "÷");
                    isPressDiv = true;
                    isHaveFloat = false;
                    floatNum = 0;
                    isPressCube = false;
                    isPressSqrt = false;
                    isPressPi =false;
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInvalid) {
                    result.setText("");
                    isInvalid = false;
                }
                if (isPressEqu) {
                    inputs.add(lastResult);
                    isPressEqu = false;
                    result.setText("Ans");
                }

                if (!isPressSub && !(isPressPlus && isPressDiv || isPressPlus && isPressMul)) {
                    if (!isPressSqrt) {
                        if (isSoundOpen)
                            playMusic(R.raw.sweet_minus);
                        inputs.add("-");
                        result.setText(result.getText() + "-");
                        isPressSub = true;
                        isHaveFloat = false;
                        floatNum = 0;
                        isPressPi =false;
                    }
                }
                //如果减号前面不是是开方或者是开立 则开方或开立方为false
                if (inputs.size() >= 2) {
                    if (inputs.get(inputs.size() - 2).equals("^")) {
                        isPressSqrt = false;
                    } else if (inputs.get(inputs.size() - 2).equals("^3")) {
                        isPressCube = false;
                    }
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInvalid) {
                    result.setText("");
                    isInvalid = false;
                }
                if (isPressEqu) {
                    inputs.add(lastResult);
                    isPressEqu = false;
                    result.setText("Ans");
                }
                if (!isPressMul && !isPressDiv && !isPressSub && !isPressPlus && !isPressSqrt && !isPressCube) {
                    if (isSoundOpen)
                        playMusic(R.raw.sweet_multi);
                    inputs.add("*");
                    result.setText(result.getText() + "×");
                    isPressMul = true;
                    isHaveFloat = false;
                    floatNum = 0;
                    isPressCube = false;
                    isPressSqrt = false;
                    isPressPi =false;
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInvalid) {
                    result.setText("");
                    isInvalid = false;
                }
                if (isPressEqu) {
                    inputs.add(lastResult);
                    isPressEqu = false;
                    result.setText("Ans");
                }
                if (!isPressPlus && !(isPressSub && isPressDiv || isPressSub && isPressMul)) {
                    if (isSoundOpen)
                        playMusic(R.raw.sweet_plus);
                    inputs.add("+");
                    result.setText(result.getText() + "+");
                    isPressPlus = true;
                    isHaveFloat = false;
                    floatNum = 0;
                    isPressPi =false;
                }
                //如果加号前面不是是开方或者是开立 则开方或开立方为false
                if (inputs.size() >= 2) {
                    if (inputs.get(inputs.size() - 2).equals("^")) {
                        isPressSqrt = false;
                    } else if (inputs.get(inputs.size() - 2).equals("^3")) {
                        isPressCube = false;
                    }
                }
            }
        });
        //开方
        btnsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInvalid) {
                    result.setText("");
                    isInvalid = false;
                }
                if (isPressEqu) {
                    isPressEqu = false;
                    inputs.clear();
                    temp.clear();
                    temp2.clear();
                    result.setText("");
                }
                if (inputs.size() == 0 && !isHaveFloat) {
                    inputs.add("^");
                    result.setText(result.getText() + "√");
                    isPressSqrt = true;
                    isHaveFloat = false;
                    floatNum = 0;
                }
                Log.v("$$$$$$$$$$$$$$$$", String.valueOf(!isPressCube && !isPressSqrt && (isPressMul || isPressSub || isPressDiv || isPressPlus) && !isHaveFloat));
                if (!isPressCube && !isPressSqrt && (isPressMul || isPressSub || isPressDiv || isPressPlus) && !isHaveFloat) {
                    inputs.add("^");
                    result.setText(result.getText() + "√");
                    isPressSqrt = true;
                    isHaveFloat = false;
                    floatNum = 0;
                }
            }
        });
        //开立方
        btncube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInvalid) {
                    result.setText("");
                    isInvalid = false;
                }
                if (isPressEqu) {
                    isPressEqu = false;
                    inputs.clear();
                    temp.clear();
                    temp2.clear();
                    result.setText("");
                }
                if (inputs.size() == 0 && !isHaveFloat) {
                    inputs.add("^3");
                    result.setText(result.getText() + "³√");
                    isPressCube = true;
                    isHaveFloat = false;
                    floatNum = 0;
                }
                if (!isPressCube && !isPressSqrt && (isPressMul || isPressSub || isPressDiv || isPressPlus) && !isHaveFloat) {
                    inputs.add("^3");
                    result.setText(result.getText() + "³√");
                    isPressCube = true;
                    isHaveFloat = false;
                    floatNum = 0;
                }
            }
        });
        //清除按钮
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSoundOpen)
                    playMusic(R.raw.sweet_ac);
                inputs.clear();
                temp.clear();
                isPressEqu = false;
                isPressDiv = false;
                isPressPlus = false;
                isPressSub = false;
                isPressMul = false;
                isHaveFloat = false;
                isPressSqrt = false;
                isPressCube = false;
                floatNum = 0;
                isPressPi =false;
                result.setText("");
            }
        });

        btnpi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (isInvalid) {
                    result.setText("");
                    isInvalid = false;
                }
                if (isPressEqu || inputs.size() == 0) {
                    inputs.add("pi");
                    result.setText(result.getText() + "π");
                    isPressPi = true;
                    isHaveFloat = false;
                    floatNum = 0;
                }
                if (!isPressPi && ((isPressMul || isPressSub || isPressDiv || isPressPlus || isPressCube || isPressSqrt) && !isHaveFloat)) {
                    if (inputs.size() == 1) {
                        if (inputs.get(0).equals("+")) {
                            inputs.set(0, "pi");
                        } else if (inputs.get(0).equals("-")) {
                            inputs.set(0, "-pi");
                        }else {
                            inputs.add("pi");
                        }
                    } else if (inputs.size() >= 2) {
                            if (inputs.get(inputs.size() - 1).equals("+")) {
                                if (inputs.get(inputs.size() - 2).equals("+") || inputs.get(inputs.size() - 2).equals("-") || inputs.get(inputs.size() - 2).equals("*") || inputs.get(inputs.size() - 2).equals("/") || inputs.get(inputs.size() - 2).equals("^") || inputs.get(inputs.size() - 2).equals("^3")) {
                                    inputs.set(inputs.size() - 2, "pi");
                                } else {
                                    inputs.add("pi");
                                }
                            } else if (inputs.get(inputs.size() - 1).equals("-")) {
                                if (inputs.get(inputs.size() - 2).equals("+") || inputs.get(inputs.size() - 2).equals("-") || inputs.get(inputs.size() - 2).equals("*") || inputs.get(inputs.size() - 2).equals("/") || inputs.get(inputs.size() - 2).equals("^") || inputs.get(inputs.size() - 2).equals("^3")) {
                                    inputs.set(inputs.size() - 2, "-pi");
                                } else {
                                    inputs.add("pi");
                                }
                            } else {
                                inputs.add("pi");
                            }
                        }
                        result.setText(result.getText() + "π");
                        isPressPi = true;
                        isPressEqu = false;
                        isPressDiv = false;
                        isPressPlus = false;
                        isPressSub = false;
                        isPressMul = false;
                        isHaveFloat = false;
                        isPressCube = false;
                        isPressSqrt = false;
                        floatNum = 0;
                    }
                }
        });
        //重点处理等号
        btnEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPressEqu) {
                    if (inputs.size() == 0) {
                        if (isSoundOpen)
                            playMusic(R.raw.error);
                        result.setText("您还没输入呢!");
                        inputs.clear();
                        temp.clear();
                        isInvalid = true;
                        return;
                    } else {
                        String first = inputs.get(0);
                        if (first.equals("/") || first.equals("*")) {
                            if (isSoundOpen)
                                playMusic(R.raw.error);
                            result.setText("无效的输入!");
                            inputs.clear();
                            temp.clear();
                            isInvalid = true;
                            return;
                        }
                        String last = inputs.get(inputs.size() - 1);
                        if (last.equals("+") || last.equals("-") || last.equals("/") || last.equals("*") || last.equals("^") || last.equals("^3")) {
                            if (isSoundOpen)
                                playMusic(R.raw.error);
                            result.setText("无效的输入!");
                            inputs.clear();
                            temp.clear();
                            isInvalid = true;
                            return;
                        }
                        if (isSoundOpen)
                            playMusic(R.raw.sweet_equal);
                        Log.v("#############", inputs.toString());
                        //将pi替换成数字
                        for(int k=0;k<inputs.size();k++){
                            if(inputs.get(k).equals("pi")){
                                inputs.set(k,String.valueOf(Math.PI));
                            }
                            if(inputs.get(k).equals("-pi")){
                                inputs.set(k,"-"+String.valueOf(Math.PI));
                            }
                        }
                        //优先处理开方和开平方
                        for (int j = 0; j < inputs.size(); j++) {
                            if (inputs.get(j).equals("^")) {
                                String next = inputs.get(j + 1);
                                temp2.add(String.valueOf(Math.sqrt(Double.valueOf(next))));
                                j++;
                            } else if (inputs.get(j).equals("^3")) {
                                String next = inputs.get(j + 1);
                                if (Double.valueOf(next) < 0) {
                                    temp2.add("-" + String.valueOf(Math.pow(-Double.valueOf(next), 1.0 / 3)));
                                } else {
                                    temp2.add(String.valueOf(Math.pow(Double.valueOf(next), 1.0 / 3)));
                                }
                                j++;
                            } else {
                                temp2.add(inputs.get(j));
                            }
                        }
                        Log.v("#######temp2", temp2.toString());
                        for (int index = 0; index < temp2.size(); index++) {
                            if (temp2.get(index).equals("*") || temp2.get(index).equals("/")) {
                                //取temp的最后一个和inputs的下一个
                                int tempSize = temp.size();
                                String lastTemp = temp.get(tempSize - 1);
                                String next = temp2.get(index + 1);
                                if (temp2.get(index).equals("*")) {
                                    temp.set(tempSize - 1, String.valueOf(new BigDecimal(lastTemp).multiply(new BigDecimal(next))));
                                    index++;
                                } else {
                                    temp.set(tempSize - 1, String.valueOf(new BigDecimal(lastTemp).divide(new BigDecimal(next), 100, 5)));
                                    index++;
                                }
                            } else {
                                temp.add(temp2.get(index));
                            }
                        }
                        Log.v("$$$$$$$$$$$$$$$", temp.toString());
                        //只剩下加号和减号未处理
                        for (int i = 0; i < temp.size(); i++) {
                            if (temp.get(i).equals("-")) {
                                if(i==0){
                                    temp.set(i+1,"-"+temp.get(i+1));
                                }else{
                                    temp.set(i + 1, String.valueOf(new BigDecimal(temp.get(i - 1)).subtract(new BigDecimal(temp.get(i + 1)))));
                                }
                                i++;
                            } else if (temp.get(i).equals("+")) {
                                if(i>=1)
                                    temp.set(i + 1, String.valueOf(new BigDecimal(temp.get(i - 1)).add(new BigDecimal(temp.get(i + 1)))));
                                i++;
                            }
                        }
                        //result.setText(temp.get(temp.size()-1));
                        result.setText(result.getText() + "=" + doResult(temp.get(temp.size() - 1)));
                        lastResult = doResult(temp.get(temp.size() - 1));
                        inputs.clear();
                        temp.clear();
                        temp2.clear();
                    }
                    isPressEqu = true;
                    isPressDiv = false;
                    isPressPlus = false;
                    isPressSub = false;
                    isPressMul = false;
                    isHaveFloat = false;
                    isPressCube = false;
                    isPressSqrt = false;
                    floatNum = 0;
                    isPressPi =false;
                } else {
                    isPressEqu = true;
                }
            }
        });
    }

    protected int initButton() {
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnEqu = (Button) findViewById(R.id.btnEqu);
        btnC = (Button) findViewById(R.id.btnC);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMul = (Button) findViewById(R.id.btnMul);
        result = (TextView) findViewById(R.id.tvResult);
        btndot = (Button) findViewById(R.id.btndot);
        btnpi = (Button) findViewById(R.id.btnpi);
        btnsqrt = (Button) findViewById(R.id.btnsqrt);
        btncube = (Button) findViewById(R.id.btncube);
        try{
            SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);
            // 2. 取出数据
            isSoundOpen= pref.getBoolean("isSoundOpen", true);
        }catch (Exception e){
            isSoundOpen = true;
        }
        return 0;
    }

    protected void doNumInput(String input) {
        if (isInvalid) {
            result.setText("");
            isInvalid = false;
        }
        if (isPressEqu) {
            inputs.clear();
            temp.clear();
            isPressEqu = false;
            isPressDiv = false;
            isPressPlus = false;
            isPressSub = false;
            isPressMul = false;
            isHaveFloat = false;
            floatNum = 0;
            result.setText("");
            isPressCube = false;
            isPressSqrt = false;
            isPressPi = false;
        }
        isPressCube = false;
        isPressSqrt = false;
        int size = inputs.size();
        if (size == 0) {
            inputs.add(input);
            return;
        }
        String last = inputs.get(size - 1);
        if(last.equals("pi")){
            Log.v("&&&&&&",result.getText().toString());
            result.setText(result.getText().toString().substring(0,result.getText().length()-1));
            return;
        }
        if (last.equals("-")) {
            if (size == 1) {
                if (isHaveFloat) {
                    inputs.set(size - 1, "-" + String.valueOf(Float.parseFloat(input) / 10));
                    floatNum++;
                } else {
                    inputs.set(size - 1, "-" + String.valueOf(input));
                }
                return;
            } else if (size >= 2) {
                if (inputs.get(size - 2).equals("/") || inputs.get(size - 2).equals("*") || inputs.get(size - 2).equals("+") || inputs.get(size - 2).equals("^3")) {
                    if(!isHaveFloat){
                        inputs.set(size - 1, "-"+String.valueOf(input));
                    }else {
                        inputs.set(size - 1,"-"+String.valueOf(Float.parseFloat(input) / 10));
                        floatNum++;
                    }
                    //inputs.set(size - 1, "-" + String.valueOf(input));
                    return;
                }
            }
        }
        if (last.equals("+")) {
            if (size == 1) {
                if (isHaveFloat) {
                    inputs.set(size - 1, String.valueOf(Float.parseFloat(input) / 10));
                    floatNum++;
                } else {
                    inputs.set(size - 1, String.valueOf(input));
                }
                return;
            } else if (size >= 2) {
                if (inputs.get(size - 2).equals("/") || inputs.get(size - 2).equals("*") || inputs.get(size - 2).equals("-") || inputs.get(size - 2).equals("^") || inputs.get(size - 2).equals("^3")) {
                    if(!isHaveFloat){
                        inputs.set(size - 1, String.valueOf(input));
                    }else {
                        inputs.set(size - 1, String.valueOf(Float.parseFloat(input) / 10));
                        floatNum++;
                    }
                    return;
                }
            }
        }
        if (last.equals("*") || last.equals("/") || last.equals("+") || last.equals("-") || last.equals("^") || last.equals("^3")) {
            if (isHaveFloat) {
                inputs.add(String.valueOf(Float.parseFloat(input) / 10));
            } else {
                inputs.add(input);
            }
        } else {
            String prefix = "";
            if (last.contains("-")) {
                prefix = "-";
            }
            if (!isHaveFloat) {
                BigDecimal tempint = new BigDecimal(last).floatValue() >= 0 ? new BigDecimal(last) : new BigDecimal(last).negate();
                inputs.set(size - 1, prefix + String.valueOf(tempint.multiply(new BigDecimal(10)).add(new BigDecimal(input))));
            } else {
                BigDecimal tempfloat = new BigDecimal(last).floatValue() >= 0 ? new BigDecimal(last) : new BigDecimal(last).negate();
                inputs.set(size - 1, prefix + String.valueOf(tempfloat.add(new BigDecimal(Math.pow(10, -floatNum) * Integer.parseInt(input))).doubleValue()));
            }
        }
        if (isHaveFloat) {
            floatNum++;
        }
    }

    //处理结果 去除.0
    protected String doResult(String result) {
        BigDecimal tempResultBig = new BigDecimal(result);
        BigDecimal tempResultI = new BigDecimal(tempResultBig.intValue());
        if (Math.abs(tempResultBig.subtract(tempResultI).doubleValue()) > 0.00000001) {
            if (result.contains(".")) {
                for (int index = 0; index < 100; index++) {
                    if (result.endsWith("0")) {
                        result = result.substring(0, result.length() - 1);
                    }
                }
            }
            if (result.endsWith(".")) {
                result = result.substring(0, result.length() - 1);
            }
            return result;
        }
        return String.valueOf(tempResultI);
    }

    //判断是否为浮点数
    protected Boolean isFloat(String result) {
        if (result.equals("+") || result.equals("-") || result.equals("*") || result.equals("/")) {
            return false;
        }
        BigDecimal tempResultBig = new BigDecimal(result);
        BigDecimal tempResultI = new BigDecimal(tempResultBig.intValue());
        if (Math.abs(tempResultBig.subtract(tempResultI).doubleValue()) > 0.00000001) {
            return true;
        }
        return false;
    }

    /*
    播放声音
     */
    private void playMusic(int MusicId) {
        try {
            music = MediaPlayer.create(this, MusicId);
            music.start();
            music.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    music.release();
                }
            });
        }catch (Exception e){
            Log.v("play music error",e.toString());
        }
    }

    /**
     * 菜单开发 控制声音
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //android.R使用的是系统自带的图标
        if (!isSoundOpen) {
            menu.add(0, Menu.FIRST, 0, "开启声音");
        } else {
            menu.add(0, Menu.FIRST + 1, 0, "关闭声音");
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                isSoundOpen = true;
                break;
            case 2:
                isSoundOpen = false;
                break;
        }
        return true;
    }

    /**
     * 再次调出菜单时触发
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        if (!isSoundOpen) {
            menu.add(0, Menu.FIRST, 0, "开启声音");
        } else {
            menu.add(0, Menu.FIRST + 1, 0, "关闭声音");
        }
        return true;
    }

    @Override
    public  void onStop(){
            super.onStop();
        SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);
        // 创建SharedPreferences.Editor对象，用于存储数据修改
        SharedPreferences.Editor editor = pref.edit();
        // 存储数据信息
        editor.putBoolean("isSoundOpen", isSoundOpen);
        // 提交数据修改
        editor.commit();
    }
    @Override
    public  void onDestroy(){
        super.onDestroy();
        SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);
        // 创建SharedPreferences.Editor对象，用于存储数据修改
        SharedPreferences.Editor editor = pref.edit();
        // 存储数据信息
        editor.putBoolean("isSoundOpen", isSoundOpen);
        // 提交数据修改
        editor.commit();
    }
    @Override
    public  void onResume(){
        super.onResume();
        SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);
        // 2. 取出数据
        isSoundOpen= pref.getBoolean("isSoundOpen", true);
        //设置主题 白天设置2 晚上设置1
        Date today = new Date();
        if (today.getHours() >= 6 && today.getHours() <= 17) {
            setTheme(R.style.AppTheme2);
        } else {
            setTheme(R.style.AppTheme);
        }
    }
}
