/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom.D1P3D;

public class PhoneQueue {
    // Handles a phone queue. It should be possible to call this class from
    // something else than the main class, such as from GUI callback functions.
    private PhoneCall[] queue;
    private final int maxQueueSize;
    private int callsInQueue = 0; // Initially, the queue is empty.


    public PhoneQueue(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
        queue = new PhoneCall[maxQueueSize];
    }


    public int getCallsInQueue() {
        // The number of queued calls.
        return callsInQueue;
    }


    public void push(PhoneCall call) {
        // Puts a call at the high-priority end of the queue.
        // Not used by main, because it's not fair.
        System.arraycopy(queue, 0, queue, 1, maxQueueSize - 1);
        queue[0] = call;
        callsInQueue += 1;
    }

    public void addCall(PhoneCall call) {
        // Adds a call as the last one to be served.
        // First come, first served.
        if (callsInQueue < maxQueueSize) {
            queue[callsInQueue] = call;
            callsInQueue += 1;
        }
    }

    public PhoneCall pop() {
        // The call that is in turn to be served.
        if (callsInQueue > 0) {
            PhoneCall toReturn = queue[0];
            // I had a loop here, but the IDE suggested this instead:
            System.arraycopy(queue, 1, queue, 0, maxQueueSize - 1);
            callsInQueue -= 1;
            return toReturn;
        }
        else throw  new IndexOutOfBoundsException();
    }


    public boolean hasCalls() {
        // True if there are any calls in the queue.
        return (callsInQueue > 0);
    }
}
