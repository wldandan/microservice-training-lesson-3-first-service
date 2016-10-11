package com.microservice.trainning.support;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class RootResourceProcessor implements ResourceProcessor<RepositoryLinksResource> {

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {
        resource.add(new Link(new UriTemplate(linkTo(ApplicationContext.class, "").slash("events").toString() + "/{eventId}"), "event"));
        return resource;
    }
}
