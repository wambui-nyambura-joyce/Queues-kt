fun main() {
    var q = Queue(5)
    q.dequeue()
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)
    q.display()
    q.dequeue()
    q.display()
    q.enqueue(45)
    q.enqueue(32)
    q.enqueue(64)
    q.enqueue(32)
    q.display()
}
//Use geeks for geeks to study
//queue is FIFO
//enqueue->to add an element to the queue....isFull
//dequeue->remove an element....isEmpty
//peek->see what is at the front
//display()-list out items currently in queue
//ctr+alt+L->formatting

class Queue(var capacity: Int) {
    var data = IntArray(capacity)
    var front = 0
    var rear = 0

    fun enqueue(value: Int) {
        if (isFull()){
            println("Queue is full")
            return
        }
        data[rear] = value
        rear++
    }

    fun dequeue(): Int? {
        if (isEmpty()){
            println("Queue is empty")
            return null
        }
        var removed = data[front]
        for (i in front until rear-1){
            data[i]=data[i+1]
        }
        rear--
        return removed
    }

    fun peek(): Int? {
        if (isEmpty()) {
            return null
        }
        return data[front]
    }

    fun isFull(): Boolean {
        return rear == capacity
    }

    fun isEmpty(): Boolean {
        return front == rear
    }

    fun display() {
        if (isEmpty()){
            return
        }
        for (i in front until rear){
            println(data[i])
        }
    }
}