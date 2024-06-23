import axios from "axios";
import { eurekaClient } from "../config/eureka-client";

async function callService(serviceName: string, endpoint: string) {
  const instances = eurekaClient.getInstancesByAppId(serviceName.toUpperCase());
  if (instances.length === 0) {
    throw new Error(`No instances available for service: ${serviceName}`);
  }

  const instance = instances[0];
  const url = `${instance.homePageUrl}${endpoint}`;
  console.log("call api to ", url);

  try {
    const response = await axios.get(url);
    return response.data;
  } catch (error) {
    console.error(`Error calling service ${serviceName}:`, error);
    throw error;
  }
}

export default callService;
