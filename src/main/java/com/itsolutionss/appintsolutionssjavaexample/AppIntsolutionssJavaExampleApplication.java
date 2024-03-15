package com.itsolutionss.appintsolutionssjavaexample;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppIntsolutionssJavaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppIntsolutionssJavaExampleApplication.class, args);
        try (DefaultKubernetesClient client = new DefaultKubernetesClient()) {
            // Obtém o nome do pod
            String podName = System.getenv("HOSTNAME");
            System.out.println("Nome do Pod: " + podName);

            // Obtém o uso de CPU e memória do pod
            NamespacedKubernetesClient namespacedClient = client.inNamespace("default");
            Pod pod = namespacedClient.pods().withName(podName).get();
            if (pod != null) {
                ResourceRequirements resources = pod.getSpec().getContainers().get(0).getResources();
                if (resources != null) {
                    System.out.println("Uso de CPU (milicores): " + resources.getRequests().get("cpu"));
                    System.out.println("Uso de Memória (bytes): " + resources.getRequests().get("memory"));
                } else {
                    System.out.println("Recursos não definidos para o pod.");
                }
            } else {
                System.out.println("Pod não encontrado.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao obter informações do pod: " + e.getMessage());
        }
    }
}
