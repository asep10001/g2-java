<br>mengganti autowired dengan controller<br>

private final StudentService service;
    private final StudentComponent sComponent;

    StudentController(StudentService service, StudentComponent sComponent){
        this.service = service;
        this.sComponent = sComponent;
    }


<br>
<br>
belajar menggunakan @PathVariable<br>
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id){
        return this.sComponent.findStudentById(id);
