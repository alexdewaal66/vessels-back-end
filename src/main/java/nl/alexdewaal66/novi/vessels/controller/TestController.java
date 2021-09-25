package nl.alexdewaal66.novi.vessels.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
@CrossOrigin(origins = "*")
public class TestController {

    static class Prop1 {
        String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Prop1{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }

    static class Prop2 {
       String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }

    static class Test {
        Prop1 p1;
        Prop2 p2;

        public Prop1 getP1() {
            return p1;
        }

        public void setP1(Prop1 p1) {
            this.p1 = p1;
        }

        public Prop2 getP2() {
            return p2;
        }

        public void setP2(Prop2 p2) {
            this.p2 = p2;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "p1=" + p1 +
                    ", p2=" + p2 +
                    '}';
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getTest() {
        Prop1 p1 = new Prop1();
        p1.content = "1-1-1";
        Prop2 p2 = new Prop2();
        p2.content = "2-2-2";
        Test test = new Test();
        test.p1 = p1;
        test.p2 = p2;
        return ResponseEntity.ok().body(test);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> postTest(@RequestBody Test testje) {
        System.out.println("❗❗❗ testje= " + testje.toString());
        return ResponseEntity.ok().build();
    }

}
