package pers.robinz.kehu.util;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by Robinz on 2018-06-06.
 */
public class UIDUtils {
    public static long getUID() {
        Random random = new Random();
        int[] sed = new int[6];
        sed[0] = random.nextInt(10);
        sed[1] = random.nextInt(10);
        sed[2] = random.nextInt(10);
        sed[3] = random.nextInt(10);
        sed[4] = random.nextInt(10);

        String uid = String.valueOf(Calendar.getInstance().getTimeInMillis())
                .substring(4) + NumberRadomUtil.getUnsignNumber(sed);

        return Long.parseLong(uid);

    }

    public static long getUID(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Random random = new Random();
        int[] sed = new int[6];
        sed[0] = random.nextInt(10);
        sed[1] = random.nextInt(10);
        sed[2] = random.nextInt(10);
        sed[3] = random.nextInt(10);
        sed[4] = random.nextInt(10);

        String uid = String.valueOf(Calendar.getInstance().getTimeInMillis())
                .substring(4) + NumberRadomUtil.getUnsignNumber(sed);

        return Long.parseLong(uid);

    }

    public static long createUIDValue() {
        Random random = new Random();
        int[] sed = new int[6];
        sed[0] = random.nextInt(10);
        sed[1] = random.nextInt(10);
        sed[2] = random.nextInt(10);
        sed[3] = random.nextInt(10);
        sed[4] = random.nextInt(10);
        sed[5] = random.nextInt(10);

        // String uid = String.valueOf(Calendar.getInstance().getTimeInMillis())
        // + random.nextInt(9) + NumberRadomUtil.getUnsignNumber(sed);
        String uid = String.valueOf(Calendar.getInstance().getTimeInMillis()).substring(4)
                + NumberRadomUtil.getUnsignNumber(sed);

        return Long.parseLong(uid);
    }

    /**
     * 产生UID增加1秒休眠时间，避免UID冲突，用于系统启用等其他系统操作业务
     *
     * @param millis
     * @return
     */
    public static long createUIDValue(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Random random = new Random();
        int[] sed = new int[6];
        sed[0] = random.nextInt(10);
        sed[1] = random.nextInt(10);
        sed[2] = random.nextInt(10);
        sed[3] = random.nextInt(10);
        sed[4] = random.nextInt(10);
        sed[5] = random.nextInt(10);

        String uid = String.valueOf(Calendar.getInstance().getTimeInMillis()).substring(4)
                + NumberRadomUtil.getUnsignNumber(sed);

        return Long.parseLong(uid);
    }

	/*public static void main(String[] args)
    {
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(new UIDUtils().createUIDValue());

		Calendar calendar = Calendar.getInstance();
		calendar.set(2010, 9, 14, 12, 59, 59);
		System.out.println(calendar.getTimeInMillis());
		calendar.set(2011, 9, 14, 12, 59, 59);
		System.out.println(calendar.getTimeInMillis());
		calendar.set(2012, 9, 14, 12, 59, 59);
		System.out.println(calendar.getTimeInMillis());
		calendar.set(2012, 9, 14, 11, 59, 59);
		System.out.println(calendar.getTimeInMillis());

	}*/
}

