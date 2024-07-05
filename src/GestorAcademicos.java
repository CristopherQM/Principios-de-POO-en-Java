import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademicos implements ServiciosAcademicos  {

        private ArrayList<Estudiante> estudiantes;
        private ArrayList<Cursos> cursos;
        private HashMap<Integer, ArrayList<Integer>> estudiantesPorCurso;

        public GestorAcademicos() {
            this.estudiantes = new ArrayList<>();
            this.cursos = new ArrayList<>();
            this.estudiantesPorCurso = new HashMap<>();
        }
        public void matricularEstudiante(Estudiante estudiante) {
            estudiantes.add(estudiante);
        }

        public void agregarCurso(Cursos curso) {
            cursos.add(curso);
        }

        public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstiduanteInscristo {
            // Verificamos si el estudiante está matriculado
            if (!estudiantes.contains(estudiante)) {
                throw new IllegalArgumentException("El estudiante no está matriculado.");
            }

            // Verificamos si el estudiante ya está inscrito en el curso
            if (estudiantesPorCurso.containsKey(idCurso) && estudiantesPorCurso.get(idCurso).contains(estudiante.id)) {
                throw new EstiduanteInscristo("El estudiante ya está inscrito en el curso.");
            }

            // Inscribimos al estudiante en el curso
            if (!estudiantesPorCurso.containsKey(idCurso)) {
                estudiantesPorCurso.put(idCurso, new ArrayList<>());
            }
            estudiantesPorCurso.get(idCurso).add(estudiante.id);
        }

        public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscrito {
            // Verificamos si el estudiante está inscrito en el curso
            if (!estudiantesPorCurso.containsKey(idCurso) || !estudiantesPorCurso.get(idCurso).contains(idEstudiante)) {
                throw new EstudianteNoInscrito("El estudiante no está inscrito en el curso o el ID del curso no es válido.");
            }

            // Desinscribimos al estudiante del curso
            estudiantesPorCurso.get(idCurso).remove(Integer.valueOf(idEstudiante));
        }

        // Método para imprimir estudiantes
        public void imprimirEstudiantes() {
            System.out.println("---Los estudiantes inscritos son : ---");
            for (Estudiante estudiante : estudiantes) {
                System.out.println("- " + estudiante.getNombre()); // Accede al nombre usando getNombre()
            }
        }

        // Método para imprimir cursos
        public void imprimirCursos() {
            System.out.println("---Los cursos disponibles son : ---");
            for (Cursos curso : cursos) {
                System.out.println("- " + curso.getNombre());
            }
        }

        // Método para imprimir qué estudiante está inscrito en qué curso
        public void imprimirEstudiantesPorCurso() {
            for (Cursos curso : cursos) {
                System.out.println("Curso " + curso.getNombre() + ":");
                ArrayList<Integer> estudiantesIds = estudiantesPorCurso.get(curso.getId());
                if (estudiantesIds != null) {
                    for (Integer estudianteId : estudiantesIds) {
                        for (Estudiante estudiante : estudiantes) {
                            if (estudiante.id == estudianteId) {
                                System.out.println("- " + estudiante.getNombre());
                            }
                        }
                    }
                }
                System.out.println();
            }
        }
    }




