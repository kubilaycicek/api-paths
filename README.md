# Spring-Rest-Api-All-Operations



    @Component
    public class AppPathComponent {

    @Autowired
    WebApplicationContext applicationContext;

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    public List<Operation> getApiPaths() {

        List<Operation> operations = new ArrayList<>();
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {

            Operation operation = new Operation();
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();
            PatternsRequestCondition p = info.getPatternsCondition();

            for (String url : p.getPatterns()) {
                operation.setUrl(url);
            }

            operation.setClassName(method.getMethod().getDeclaringClass().getName());
            operation.setMethod(method.getMethod().getName());

            RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
            String type = methodsCondition.toString();
            if (type != null && type.startsWith("[") && type.endsWith("]")) {
                type = type.substring(1, type.length() - 1);
                operation.setType(type);
            }
            operations.add(operation);
        }
        return operations;
    }
