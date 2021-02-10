## Rest Api All Operations
I developed a component that lists the operations in API.


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

## Result 
    ```
        [
            {
                "url": "/products/addProduct",
                "method": "addProduct",
                "className": "com.kubilaycicek.product.rest.ProductController",
                "type": "POST"
            },
            {
                "url": "/products/updateProduct/{id}",
                "method": "updateProduct",
                "className": "com.kubilaycicek.product.rest.ProductController",
                "type": "PUT"
            },
            {
                "url": "/error",
                "method": "error",
                "className": "org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController",
                "type": ""
            },
            {
                "url": "/products/product/{id}",
                 "method": "getProduct",
                 "className": "com.kubilaycicek.product.rest.ProductController",
                 "type": "GET"
            },
            {
                "url": "/products/list",
                "method": "getList",
                "className": "com.kubilaycicek.product.rest.ProductController",
                "type": "GET"
             },
             {
                "url": "/error",
                "method": "errorHtml",
                "className": "org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController",
                "type": ""
             },
             {
                "url": "/products/product/delete/{id}",
                "method": "deleteProduct",
                "className": "com.kubilaycicek.product.rest.ProductController",
                "type": "DELETE"
              },
              {
                "url": "/getAllApiPaths",
                "method": "getAllApiPaths",
                "className": "com.kubilaycicek.product.rest.ApiController",
                "type": "GET"
               }
    ] 
    ```
