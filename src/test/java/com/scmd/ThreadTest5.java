package com.scmd;

import javax.naming.InsufficientResourcesException;

/**
 * @program:
 * @description: 动态的锁顺序死锁的解决方案——通过锁顺序来避免死锁
 * @author: zhouzhixiang
 * @create: 2018-11-16 20:03
 */
public class ThreadTest5 {

    // 加时赛锁
    private static final Object tieLock = new Object();

    class Account implements Comparable{
        String username;
        String password;
        long moneycount;

        void debit(long amount) {
            moneycount = moneycount - amount;
        }

        void credit(long amount) {
            moneycount = moneycount + amount;
        }

        @Override
        public int compareTo(Object o) {
            return (int) (moneycount - ((long)o));
        }
    }

    /**
     * 此方法容易发生动态的锁顺序死锁——错误方式
     * @param fromAccount 转账方
     * @param toAccount   收账方
     * @param amount      转账金额
     */
    public void tranferMoney(Account fromAccount, Account toAccount, long amount) throws InsufficientResourcesException {
        synchronized(fromAccount) {
            synchronized (toAccount) {
                if(fromAccount.compareTo(amount) < 0)
                    throw new InsufficientResourcesException();
                else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
    }

    /**
     * 通过锁顺序来避免死锁——正确方法
     * @param fromAccount 转账方
     * @param toAccount   收账方
     * @param amount      转账金额
     */
    public void tranferMoney2(Account fromAccount, Account toAccount, long amount) throws InsufficientResourcesException {
        class Helper {
            public void tranfer() throws InsufficientResourcesException {
                if(fromAccount.compareTo(amount) < 0)
                    throw new InsufficientResourcesException();
                else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }

        int fromHashCode = System.identityHashCode(fromAccount);
        int toHashCode = System.identityHashCode(toAccount);

        if(fromHashCode < toHashCode) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    new Helper().tranfer();
                }
            }
        }else if (fromHashCode > toHashCode) {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    new Helper().tranfer();
                }
            }
        }else {
            // 加时赛锁
            synchronized (tieLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        new Helper().tranfer();
                    }
                }
            }
        }
    }


}
