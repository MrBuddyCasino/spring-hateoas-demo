# spring-hateoas-demo
Demo project for https://github.com/spring-projects/spring-hateoas/issues/698

HowTo
- run de.codecentric.hateoas.Main
- attach a profiler, e.g. VisualVM CPU profiler (not sampler)
- open http://localhost:8080/inventory/product/123123?plant=6040&requirementCategory=A60382000 in your browser
- refresh a few times
- be amazed that linkTo() takes about 17ms to execute
