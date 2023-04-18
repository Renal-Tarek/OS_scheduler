/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package os;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author renal
 */
public class Algorithms {
    
    public static float total_turnAround_time;
    public static float total_waiting_time;
    
    
    private static Job empty(float timer, int i, ArrayList<Process> p) {
        Job j = new Job(-1, timer, p.get(i).getArrival_time() - timer);
        return j;
    }
    
     public static ArrayList<Job> RR(ArrayList<Process> p, int qt) {
        Process.setCompare_type(0);
        Collections.sort(p);
        Queue<Process> q = new LinkedList<>();
        ArrayList<Job> jobs = new ArrayList<Job>();
        float timer = p.get(0).getArrival_time();
        Job j;
        int i = 0;
        while (i < p.size() || !q.isEmpty()) {
            while (i < p.size() && timer >= p.get(i).getArrival_time()) {
                q.add(p.get(i));
                i++;
            }
            if (q.isEmpty()) {
                j = empty(timer, i, p);
                timer += j.getBurst_time();
                jobs.add(j);
            } else{
                if (q.peek().getRemaining_burst_time()> qt) {
                    j = new Job(q.peek().getProcess_number(), timer, qt, q.peek());
                    jobs.add(j);
                    q.peek().setRemaining_burst_time(q.peek().getRemaining_burst_time()- qt);
                    timer += j.getBurst_time();
                    while (i < p.size() && timer >= p.get(i).getArrival_time()) {
                        q.add(p.get(i));
                        i++;
                    }
                    q.add(q.peek());
                } else {
                    j = new Job(q.peek().getProcess_number(), timer, q.peek().getRemaining_burst_time(), q.peek());
                    jobs.add(j);
                    timer += j.getBurst_time();
                }
                q.poll();                
            
        }
    }
        return jobs ;
    
}
     
   public static ArrayList<ResultProcess> fcfs(ArrayList<Process> p) {
        Process.setCompare_type(0);
        Collections.sort(p);
        int timer =p.get(0).getArriving_time();
        ArrayList<ResultProcess> jobs = new ArrayList<ResultProcess>();
        for(int i=0;i<p.size();i++)
        {
            ResultProcess j = new ResultProcess(p.get(i).getProsess_name(), timer, p.get(i).getBurst_time(), p.get(i));
            jobs.add(j);
            p.get(i).setFinish_time(timer + p.get(i).getBurst_time());
            timer += p.get(i).getBurst_time();
        }
        return jobs;
    }
     
      public static void timing (ArrayList<Job> jobs , ArrayList<Process> ps){
        for(Job j: jobs){
            if(j.getJob_number()== -1) continue;
            float finish_time = j.getStart_time()+j.getBurst_time();
            j.getP().setFinish_time(finish_time);
        }
        total_turnAround_time = 0;
        total_waiting_time = 0;
        
        for(Process p:ps){
            float turnAround_time = p.getFinish_time() - p.getArrival_time();
            float waiting_time = turnAround_time - p.getBurst_time();
            p.setTurnAround_time(turnAround_time);
            p.setWaiting_time(waiting_time);
            total_turnAround_time += turnAround_time;
            total_waiting_time += waiting_time;
        }
    }
      
    
    
}
