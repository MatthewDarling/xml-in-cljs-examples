(ns cljs-xml.core
  (:require [clojure.data.xml :as xml]))

(enable-console-print!)

;;;from https://github.com/ruedigergad/test2junit/blob/master/ghpages/test-results/xml/test2junit.example-tests.xml
;;;but with newlines removed in between tags, because they get parsed as :content nodes
(def junit-example
  "<?xml version=\"1.0\" encoding=\"UTF-8\"?><testsuite name=\"test2junit.example-tests\" errors=\"1\" failures=\"1\" tests=\"4\" time=\"0.0258\" timestamp=\"2017-05-25_13:06:25+0200\"><testcase name=\"erroneous-test\" classname=\"test2junit.example-tests\" time=\"0.0169\"><error message=\"In file example_tests.clj at line 29:\">expected: (= foo (/ 1 0))
      actual: java.lang.ArithmeticException: Divide by zero
      at clojure.lang.Numbers.divide (Numbers.java:158)
      clojure.lang.Numbers.divide (Numbers.java:3808)
      test2junit.example_tests$fn__1090.invokeStatic (example_tests.clj:30)
      test2junit.example_tests/fn (example_tests.clj:27)
      clojure.test$test_var$fn__7983.invoke (test.clj:716)
      clojure.test$test_var.invokeStatic (test.clj:716)
      clojure.test$test_var.invoke (test.clj:707)
      clojure.test$test_vars$fn__8005$fn__8010.invoke (test.clj:734)
      clojure.test$default_fixture.invokeStatic (test.clj:686)
      clojure.test$default_fixture.invoke (test.clj:682)
      clojure.test$test_vars$fn__8005.invoke (test.clj:734)
      clojure.test$default_fixture.invokeStatic (test.clj:686)
      clojure.test$default_fixture.invoke (test.clj:682)
      clojure.test$test_vars.invokeStatic (test.clj:730)
      clojure.test$test_all_vars.invokeStatic (test.clj:736)
      clojure.test$test_ns.invokeStatic (test.clj:757)
      clojure.test$test_ns.invoke (test.clj:742)
      clojure.lang.AFn.applyToHelper (AFn.java:154)
      clojure.lang.AFn.applyTo (AFn.java:144)
      clojure.core$apply.invokeStatic (core.clj:646)
      clojure.core$apply.invoke (core.clj:641)
      test2junit.core$apply_junit_output_hook$fn__828$fn__837$fn__846$fn__847.invoke (core.clj:53)
      test2junit.core$apply_junit_output_hook$fn__828$fn__837$fn__846.invoke (core.clj:52)
      test2junit.core$apply_junit_output_hook$fn__828$fn__837.invoke (core.clj:51)
      test2junit.core$apply_junit_output_hook$fn__828.doInvoke (core.clj:51)
      clojure.lang.RestFn.applyTo (RestFn.java:139)
      clojure.core$apply.invokeStatic (core.clj:648)
      clojure.core$apply.invoke (core.clj:641)
      robert.hooke$compose_hooks$fn__11994.doInvoke (hooke.clj:40)
      clojure.lang.RestFn.applyTo (RestFn.java:137)
      clojure.core$apply.invokeStatic (core.clj:646)
      clojure.core$apply.invoke (core.clj:641)
      robert.hooke$run_hooks.invokeStatic (hooke.clj:46)
      robert.hooke$run_hooks.invoke (hooke.clj:45)
      robert.hooke$prepare_for_hooks$fn__11999$fn__12000.doInvoke (hooke.clj:54)
      clojure.lang.RestFn.applyTo (RestFn.java:137)
      clojure.lang.AFunction$1.doInvoke (AFunction.java:29)
      clojure.lang.RestFn.invoke (RestFn.java:408)
      user$eval965$fn__1016.invoke (NO_SOURCE_FILE:0)
      clojure.lang.AFn.applyToHelper (AFn.java:156)
      clojure.lang.AFn.applyTo (AFn.java:144)
      clojure.core$apply.invokeStatic (core.clj:648)
      clojure.core$apply.invoke (core.clj:641)
      leiningen.core.injected$compose_hooks$fn__899.doInvoke (NO_SOURCE_FILE:0)
      clojure.lang.RestFn.applyTo (RestFn.java:137)
      clojure.core$apply.invokeStatic (core.clj:646)
      clojure.core$apply.invoke (core.clj:641)
      leiningen.core.injected$run_hooks.invokeStatic (NO_SOURCE_FILE:0)
      leiningen.core.injected$run_hooks.invoke (NO_SOURCE_FILE:0)
      leiningen.core.injected$prepare_for_hooks$fn__904$fn__905.doInvoke (NO_SOURCE_FILE:0)
      clojure.lang.RestFn.applyTo (RestFn.java:137)
      clojure.lang.AFunction$1.doInvoke (AFunction.java:29)
      clojure.lang.RestFn.invoke (RestFn.java:408)
      clojure.core$map$fn__4785.invoke (core.clj:2646)
      clojure.lang.LazySeq.sval (LazySeq.java:40)
      clojure.lang.LazySeq.seq (LazySeq.java:49)
      clojure.lang.Cons.next (Cons.java:39)
      clojure.lang.RT.boundedLength (RT.java:1749)
      clojure.lang.RestFn.applyTo (RestFn.java:130)
      clojure.core$apply.invokeStatic (core.clj:648)
      clojure.test$run_tests.invokeStatic (test.clj:767)
      clojure.test$run_tests.doInvoke (test.clj:767)
      clojure.lang.RestFn.applyTo (RestFn.java:137)
      clojure.core$apply.invokeStatic (core.clj:646)
      clojure.core$apply.invoke (core.clj:641)
      user$eval965$fn__1028$fn__1059.invoke (NO_SOURCE_FILE:0)
      user$eval965$fn__1028$fn__1029.invoke (NO_SOURCE_FILE:0)
      user$eval965$fn__1028.invoke (NO_SOURCE_FILE:0)
      user$eval965.invokeStatic (NO_SOURCE_FILE:0)
      user$eval965.invoke (NO_SOURCE_FILE:-1)
      clojure.lang.Compiler.eval (Compiler.java:6927)
      clojure.lang.Compiler.eval (Compiler.java:6917)
      clojure.lang.Compiler.eval (Compiler.java:6890)
      clojure.core$eval.invokeStatic (core.clj:3105)
      clojure.core$eval.invoke (core.clj:3101)
      leiningen.core.eval$fn__5779.invokeStatic (eval.clj:342)
      leiningen.core.eval/fn (eval.clj:332)
      clojure.lang.MultiFn.invoke (MultiFn.java:233)
      leiningen.core.eval$eval_in_project.invokeStatic (eval.clj:366)
      leiningen.core.eval$eval_in_project.invoke (eval.clj:356)
      leiningen.test$test.invokeStatic (test.clj:216)
      leiningen.test$test.doInvoke (test.clj:182)
      clojure.lang.RestFn.invoke (RestFn.java:410)
      clojure.lang.AFn.applyToHelper (AFn.java:154)
      clojure.lang.RestFn.applyTo (RestFn.java:132)
      clojure.core$apply.invokeStatic (core.clj:648)
      clojure.core$apply.invoke (core.clj:641)
      leiningen.test2junit$test2junit$fn__875.invoke (test2junit.clj:55)
      leiningen.test2junit$test2junit.invokeStatic (test2junit.clj:53)
      leiningen.test2junit$test2junit.doInvoke (test2junit.clj:31)
      clojure.lang.RestFn.invoke (RestFn.java:410)
      clojure.lang.Var.invoke (Var.java:379)
      clojure.lang.AFn.applyToHelper (AFn.java:154)
      clojure.lang.Var.applyTo (Var.java:700)
      clojure.core$apply.invokeStatic (core.clj:648)
      clojure.core$apply.invoke (core.clj:641)
      leiningen.core.main$partial_task$fn__5932.doInvoke (main.clj:272)
      clojure.lang.RestFn.invoke (RestFn.java:410)
      clojure.lang.AFn.applyToHelper (AFn.java:154)
      clojure.lang.RestFn.applyTo (RestFn.java:132)
      clojure.lang.AFunction$1.doInvoke (AFunction.java:29)
      clojure.lang.RestFn.applyTo (RestFn.java:137)
      clojure.core$apply.invokeStatic (core.clj:648)
      clojure.core$apply.invoke (core.clj:641)
      leiningen.core.main$apply_task.invokeStatic (main.clj:322)
      leiningen.core.main$apply_task.invoke (main.clj:308)
      leiningen.core.main$resolve_and_apply.invokeStatic (main.clj:328)
      leiningen.core.main$resolve_and_apply.invoke (main.clj:324)
      leiningen.core.main$_main$fn__5998.invoke (main.clj:401)
      leiningen.core.main$_main.invokeStatic (main.clj:394)
      leiningen.core.main$_main.doInvoke (main.clj:391)
      clojure.lang.RestFn.invoke (RestFn.java:408)
      clojure.lang.Var.invoke (Var.java:379)
      clojure.lang.AFn.applyToHelper (AFn.java:154)
      clojure.lang.Var.applyTo (Var.java:700)
      clojure.core$apply.invokeStatic (core.clj:646)
      clojure.main$main_opt.invokeStatic (main.clj:314)
      clojure.main$main_opt.invoke (main.clj:310)
      clojure.main$main.invokeStatic (main.clj:421)
      clojure.main$main.doInvoke (main.clj:384)
      clojure.lang.RestFn.invoke (RestFn.java:436)
      clojure.lang.Var.invoke (Var.java:388)
      clojure.lang.AFn.applyToHelper (AFn.java:160)
      clojure.lang.Var.applyTo (Var.java:700)
      clojure.main.main (main.java:37)

      at: example_tests.clj:29</error></testcase><testcase name=\"write-to-stderr-and-stdout\" classname=\"test2junit.example-tests\" time=\"0.0011\"></testcase><testcase name=\"passing-test\" classname=\"test2junit.example-tests\" time=\"0.0003\"></testcase><testcase name=\"failing-test\" classname=\"test2junit.example-tests\" time=\"0.0032\"><failure message=\"In file example_tests.clj at line 19:\">expected: (= foo 0)
      actual: (not (= 1 0))
      at: example_tests.clj:19</failure></testcase><system-err>Output to stderr.</system-err><system-out>Output to stdout.
    Output to stderr.</system-out><properties><property name=\"sun.os.patch.level\" value=\"unknown\"></property><property name=\"sun.boot.class.path\" value=\"/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre/lib/resources.jar:/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre/lib/rt.jar:/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre/lib/sunrsasign.jar:/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre/lib/jsse.jar:/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre/lib/jce.jar:/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre/lib/charsets.jar:/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre/lib/jfr.jar:/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre/classes:/home/rc/.lein/self-installs/leiningen-2.7.1-standalone.jar\"></property><property name=\"sun.management.compiler\" value=\"HotSpot 64-Bit Tiered Compilers\"></property><property name=\"java.vm.info\" value=\"mixed mode\"></property><property name=\"clojure.debug\" value=\"false\"></property><property name=\"sun.boot.library.path\" value=\"/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre/lib/amd64\"></property><property name=\"java.awt.graphicsenv\" value=\"sun.awt.X11GraphicsEnvironment\"></property><property name=\"path.separator\" value=\":\"></property><property name=\"user.dir\" value=\"/home/rc/repositories/private/clojure/test2junit\"></property><property name=\"java.vm.specification.vendor\" value=\"Oracle Corporation\"></property><property name=\"user.country\" value=\"US\"></property><property name=\"java.vendor.url\" value=\"http://java.oracle.com/\"></property><property name=\"java.specification.name\" value=\"Java Platform API Specification\"></property><property name=\"line.separator\" value=\"\"></property><property name=\"file.encoding.pkg\" value=\"sun.io\"></property><property name=\"sun.cpu.endian\" value=\"little\"></property><property name=\"java.vm.version\" value=\"25.121-b14\"></property><property name=\"sun.java.launcher\" value=\"SUN_STANDARD\"> </property><property name=\"test2junit.version\" value=\"1.3.0\"></property><property name=\"java.vendor\" value=\"Oracle Corporation\"></property><property name=\"java.specification.vendor\" value=\"Oracle Corporation\"></property><property name=\"leiningen.script\" value=\"/home/rc/bin/lein\"></property><property name=\"awt.toolkit\" value=\"sun.awt.X11.XToolkit\"></property><property name=\"clojure.compile.path\" value=\"/home/rc/repositories/private/clojure/test2junit/target/classes\"></property><property name=\"leiningen.original.pwd\" value=\"/home/rc/repositories/private/clojure/test2junit\"></property><property name=\"aether.connector.userAgent\" value=\"Leiningen/2.7.1 (Java OpenJDK 64-Bit Server VM; Linux 4.10.10-200.fc25.x86_64; amd64)\"></property><property name=\"java.vm.specification.version\" value=\"1.8\"></property><property name=\"java.io.tmpdir\" value=\"/tmp\"></property><property name=\"java.home\" value=\"/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre\"></property><property name=\"java.class.path\" value=\"/home/rc/.lein/self-installs/leiningen-2.7.1-standalone.jar\"></property><property name=\"java.runtime.version\" value=\"1.8.0_121-b14\"></property><property name=\"java.vm.vendor\" value=\"Oracle Corporation\"></property><property name=\"user.language\" value=\"en\"></property><property name=\"java.vm.name\" value=\"OpenJDK 64-Bit Server VM\"></property><property name=\"java.version\" value=\"1.8.0_121\"></property><property name=\"os.arch\" value=\"amd64\"></property><property name=\"user.home\" value=\"/home/rc\"></property><property name=\"java.specification.version\" value=\"1.8\"></property><property name=\"java.ext.dirs\" value=\"/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre/lib/ext:/usr/java/packages/lib/ext\"></property><property name=\"sun.jnu.encoding\" value=\"UTF-8\"></property><property name=\"java.runtime.name\" value=\"OpenJDK Runtime Environment\"></property><property name=\"sun.io.unicode.encoding\" value=\"UnicodeLittle\"></property><property name=\"sun.arch.data.model\" value=\"64\"></property><property name=\"java.class.version\" value=\"52.0\"></property><property name=\"maven.wagon.rto\" value=\"10000\"></property><property name=\"sun.cpu.isalist\" value=\"\"></property><property name=\"file.encoding\" value=\"UTF-8\"></property><property name=\"user.timezone\" value=\"Europe/Berlin\"></property><property name=\"maven.wagon.http.ssl.easy\" value=\"false\"></property><property name=\"os.name\" value=\"Linux\"></property><property name=\"os.version\" value=\"4.10.10-200.fc25.x86_64\"></property><property name=\"file.separator\" value=\"/\"></property><property name=\"java.vm.specification.name\" value=\"Java Virtual Machine Specification\"></property><property name=\"java.awt.printerjob\" value=\"sun.print.PSPrinterJob\"></property><property name=\"java.endorsed.dirs\" value=\"/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.121-10.b14.fc25.x86_64/jre/lib/endorsed\"></property><property name=\"java.library.path\" value=\"/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib\"></property><property name=\"java.vendor.url.bug\" value=\"http://bugreport.sun.com/bugreport/\"></property><property name=\"sun.java.command\" value=\"clojure.main -m leiningen.core.main test2junit\"></property><property name=\"user.name\" value=\"rc\"></property></properties></testsuite>")

(comment (xml/parse-str junit-example))

(comment
  (xml/emit-str {:tag :testsuite
                 :attrs {:name "foo"
                         :tests "3"
                         :errors "1"
                         :failures "1"
                         :time "7002"}
                 :content
                 [{:tag :testcase
                   :attrs {:classname "foo"
                           :name "foo-test"
                           :time "1234"}
                   :content [{:tag :failure
                              :attrs {:message "In file foo_tests.clj at line 19:"}
                              :content [(clojure.string/join "\n"
                                                             ["expected: 1"
                                                              "  actual: 2"
                                                              "      at: foo.cljs:123"])]}]}
                  {:tag :testcase
                   :attrs {:classname "foo"
                           :name "bar-test"
                           :time "5678"}
                   :content []}
                  {:tag :testcase
                   :attrs {:classname "foo"
                           :name "baz-test"
                           :time "90"}
                   :content [{:tag :error
                              :attrs {:message "In file foo_tests.clj at line 29"}
                              :content [(clojure.string/join "\n"
                                                             ["expected: 1"
                                                              "  actual: java.lang.NullPointerException"
                                                              "      at: foo.cljs:456"
                                                              "      ..."])]}]}]}))
