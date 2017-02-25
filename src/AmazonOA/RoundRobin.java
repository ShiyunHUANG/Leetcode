package AmazonOA;
/**
 * 一个处理器要处理一堆request，一次只能处理一条，每次执行一个任务最多执行时间q，接着执行
 * 等待着的下一个任务。若前一个任务没执行完则放到队尾，等待下一次执行
假设只要有任务开始以后cpu是不会空闲的，也就是说cpu开始后如果空闲了就说明没
有任务了，另外Robin Round最后返回值是float
 *
 */
/* Example
 * int[] arriveTime{0,1,4} exeTime{5,2,3},maxExeTime = 3
 * Running    Waiting
 * 0 P(5)
 * 1 P(5)      P(2)*
 * 2 P(5)          *
 * 3 P(5)P(2)  P(5)*    
 * 4 P(2)      P(3)*
 * 5 P(2)P(5)      *
 * 6 P(5)          *
 * 7 P(5)P(3)      *
 * 8 P(3)
 * 9 P(3)
 * 10P(3)
 * 
 * */
public class RoundRobin {

}
