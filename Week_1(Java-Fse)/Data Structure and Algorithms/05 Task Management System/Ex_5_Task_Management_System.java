//Ex_5_Task_Management_System
class Task {
    private String taskId;
    private String taskName;
    private String status;

    // Constructor
    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    // Getters
    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", taskName=" + taskName + ", status=" + status + "]";
    }
}
class Node {
    Task task;
    Node next;

    // Constructor
    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskLinkedList {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTaskById(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTaskById(String taskId) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                if (previous == null) {
                    head = current.next; 
                } else {
                    previous.next = current.next;
                }
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }
}
public class Ex_5_Task_Management_System{
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task("T001", "Design Database", "In Progress"));
        taskList.addTask(new Task("T002", "Develop API", "Pending"));
        taskList.addTask(new Task("T003", "Test Application", "Completed"));

        
        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for task with ID T002:");
        Task task = taskList.searchTaskById("T002");
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting task with ID T002:");
        boolean deleted = taskList.deleteTaskById("T002");
        if (deleted) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nAll Tasks after deletion:");
        taskList.traverseTasks();
    }
}
