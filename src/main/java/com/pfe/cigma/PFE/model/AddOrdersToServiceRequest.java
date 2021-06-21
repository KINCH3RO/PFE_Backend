package com.pfe.cigma.PFE.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddOrdersToServiceRequest {
	int orderId;
	int serviceId;
}
