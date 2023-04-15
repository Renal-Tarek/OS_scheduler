/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

/**
 *
 * @author renal
 */
public class Process implements Comparable<Process> {
    
    private int process_number;
    private float arrival_time;
    private float burst_time;
    private float remaining_burst_time;
    private int process_priority;
    private float finish_time;
    private float waiting_time;
    private float turnAround_time;
    private static int number_of_process;
    private static int compare_type;
   


    public Process(int process_number, float arrival_time, float burst_time) {
        this.process_number = process_number;
        this.arrival_time = arrival_time;
        this.burst_time = burst_time;
        this.remaining_burst_time = burst_time;
        number_of_process++;
    }

    public Process(int process_number, int arrival_time, int burst_time, int process_priority) {
        this(process_number, arrival_time, burst_time);
        this.process_priority = process_priority;
    }
    
    
    public void setProcess_number(int process_number) {
        this.process_number = process_number;
    }

    public void setArrival_time(float arrival_time) {
        this.arrival_time = arrival_time;
    }

    public void setBurst_time(float burst_time) {
        this.burst_time = burst_time;
    }

    public void setRemaining_burst_time(float remaining_burst_time) {
        this.remaining_burst_time = remaining_burst_time;
    }
    
    public void setFinish_time(float finish_time) {
        this.finish_time = finish_time;
    }
    
    public void setProcess_priority(int process_priority) {
        this.process_priority = process_priority;
    }

    public void setWaiting_time(float waiting_time) {
        this.waiting_time = waiting_time;
    }

    public void setTurnAround_time(float turnAround_time) {
        this.turnAround_time = turnAround_time;
    }
    
    public static void setCompare_type(int compare_type) {
        Process.compare_type = compare_type;
    }
   
    
    public int getProcess_number() {
        return process_number;
    }

    public float getArrival_time() {
        return arrival_time;
    }

    public float getBurst_time() {
        return burst_time;
    }

    public float getRemaining_burst_time() {
        return remaining_burst_time;
    }
    
    public float getFinish_time() {
        return finish_time;
    }
    
    public int getProcess_priority() {
        return process_priority;
    }

    public float getWaiting_time() {
        return waiting_time;
    }

    public float getTurnAround_time() {
        return turnAround_time;
    }
    
    public static int getNumber_of_process() {
        return number_of_process;
    }

    public static int getCompare_type() {
        return compare_type;
    }
    
    @Override
    public int compareTo(Process p)
    {
        // compare with respect to arrival time ascendengly
        if(compare_type == 0)
            return (int)(this.getArrival_time() - p.getArrival_time());
        
        // compare with respect to burst time ascendengly
        else if(compare_type == 1)
            return (int)(this.getBurst_time() - p.getBurst_time());
        
        // compare with respect to priority 
//        else if(compare_type1==0 && compare_type1==0)
            
        else 
            return (int)(this.getProcess_priority() - p.getProcess_priority()); 
    }
    

}