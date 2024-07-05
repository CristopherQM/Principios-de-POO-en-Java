public interface ServiciosAcademicos {
    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Cursos curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstiduanteInscristo;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscrito;
}
