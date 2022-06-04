package com.rht.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoanBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
