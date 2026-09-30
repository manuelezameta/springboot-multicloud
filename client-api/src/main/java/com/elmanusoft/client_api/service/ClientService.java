package com.elmanusoft.client_api.service;

import com.elmanusoft.client_api.dto.ClientRequest;
import com.elmanusoft.client_api.dto.ClientResponse;
import com.elmanusoft.client_api.model.Client;
import com.elmanusoft.client_api.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientResponse createClient(ClientRequest clientRequest) {
        Client client = Client.builder()
                .firstName(clientRequest.firstName())
                .lastName(clientRequest.lastName())
                .email(clientRequest.email())
                .status(clientRequest.status())
                .build();

        Client savedClient = clientRepository.save(client);
        return new ClientResponse(
                savedClient.getId(),
                savedClient.getFirstName(),
                savedClient.getLastName(),
                savedClient.getEmail(),
                savedClient.getStatus()
        );
    }

    public List<ClientResponse> findAll() {
        return clientRepository.findAll().stream()
                .map(client -> new ClientResponse(
                        client.getId(),
                        client.getFirstName(),
                        client.getLastName(),
                        client.getEmail(),
                        client.getStatus()
                ))
                .toList();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
    }

    public Client updateClient(Long id, Client updatedClient) {
        Client existingClient = findById(id);

        existingClient.setFirstName(updatedClient.getFirstName());
        existingClient.setLastName(updatedClient.getLastName());
        existingClient.setEmail(updatedClient.getEmail());
        existingClient.setStatus(updatedClient.getStatus());

        return clientRepository.save(existingClient);
    }

    public void deleteClient(Long id) {
        Client client = findById(id);
        clientRepository.delete(client);
    }


}
