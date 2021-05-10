package javaTest2;

import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 * .signum()
 * 如果此BigDecimal<0, 则为-1
 * 如果此BigDecimal = 0，则为0
 * 如果此BigDecimal> 0, 则为1
 *
 * 、System.arraycopy的函数原型是：
 *
 *
 * public static void arraycopy(Object src,
 *                              int srcPos,
 *                              Object dest,
 *                              int destPos,
 *                              int length)
 * 其中：src表示源数组，srcPos表示源数组要复制的起始位置，desc表示目标数组，length表示要复制的长度。

 */
public class bigDecimal05 {
    public String[] test(String[] balances,String amount){
        String[] returnAmount = new String[balances.length];
        BigDecimal amountDecimal = new BigDecimal(amount);
        for(int i =0; i<balances.length;i++){
            amountDecimal = amountDecimal.subtract(new BigDecimal(balances[i]));//- (new BigDecimal(amount[i]));
            if(amountDecimal.signum()<0){
                //负数取绝对值代表扣款后的余额
                returnAmount[i]=amountDecimal.abs().toPlainString();
                //将剩余位置金额复制到对应数组
                System.arraycopy(balances,i+1,returnAmount,i+1,balances.length-i-1);
                break;
            }else{
                returnAmount[i]="0.00";
                if(i==balances.length-1){
                    throw new RuntimeException("koukuanshibai1");
                }
            }
        }
        return returnAmount;
    }
}
