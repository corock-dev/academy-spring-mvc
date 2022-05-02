# Spring MVC

## Dooray RESTful API

```java
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

@ModelAttribute("post")
public Post getPost(@PathVariable("postId") long postId){
    return postRepository.getPost(postId);
    }

@GetMapping(@ModelAttribute("post")Post post)

@PutMapping
```

```text
GET /tenants/{tenantId}/projects/{projectId}/posts/{postId}

# e.g.
/tenants/samsung/projects/galaxy/posts/12345/comment
                                            /star
                                            /...
```
