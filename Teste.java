import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    private List<Task> tasks = new ArrayList<>();
    private int nextTaskId = 1;

    @PostMapping("/tarefa")
    public ResponseEntity<Task> createTask(@RequestBody TaskRequest taskRequest) {
        if (taskRequest.getTitulo() == null || taskRequest.getUsuario() == null) {
            return ResponseEntity.badRequest().build();
        }

        Task task = new Task(nextTaskId, taskRequest.getTitulo(), taskRequest.getDescricao(), taskRequest.getUsuario(), Status.TODO);
        tasks.add(task);
        nextTaskId++;

        return ResponseEntity.ok(task);
    }

    @PutMapping("/tarefa/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") int id, @RequestBody TaskRequest taskRequest) {
        Task task = findTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        if (taskRequest.getTitulo() != null) {
            task.setTitulo(taskRequest.getTitulo());
        }

        if (taskRequest.getDescricao() != null) {
            task.setDescricao(taskRequest.getDescricao());
        }

        if (taskRequest.getUsuario() != null) {
            task.setUsuario(taskRequest.getUsuario());
        }

        return ResponseEntity.ok(task);
    }

    @GetMapping("/tarefa")
    public ResponseEntity<List<Task>> getTasksByStatus(@RequestParam("status") Status status) {
        List<Task> tasksByStatus = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus() == status) {
                tasksByStatus.add(task);
            }
        }

        return ResponseEntity.ok(tasksByStatus);
    }

    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    private static class Task {
        private int id;
        private String titulo;
        private String descricao;
        private Usuario usuario;
        private Status status;

        public Task(int id, String titulo, String descricao, Usuario usuario, Status status) {
            this.id = id;
            this.titulo = titulo;
            this.descricao = descricao;
            this.usuario = usuario;
            this.status = status;
        }

        // Getters e setters
    }

    private static class Usuario {
        private String nome;
        private String time;

        // Construtor, getters e setters
    }

    private enum Status {
        TODO, DOING, DONE
    }

    private static class TaskRequest {
        private String titulo;
        private String descricao;
        private Usuario usuario;

        // Construtor, getters e setters
    }
}
