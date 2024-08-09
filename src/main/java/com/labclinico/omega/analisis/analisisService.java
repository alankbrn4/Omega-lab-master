package com.labclinico.omega.analisis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class analisisService {

    private final analisisRepository analisisRepository;

    @Autowired
    public analisisService(analisisRepository analisisRepository) {
        this.analisisRepository = analisisRepository;
    }

    public List<analisisModel> getAllAnalisis() {
        return analisisRepository.findAll();
    }

    public Optional<analisisModel> getAnalisisById(String id) {
        return analisisRepository.findById(id);
    }

    public analisisModel saveAnalisis(analisisModel analisis) {
        return analisisRepository.save(analisis);
    }

    public void deleteAnalisis(String id) {
        analisisRepository.deleteById(id);
    }

    public List<analisisModel> getAnalisisByMuestra(String muestraId) {
        return analisisRepository.findByIdMuestra(muestraId);
    }

    //public List<analisisModel> getAnalisisByEstado(String estado) {
    //    return analisisRepository.findByEstado(estado);
    //}
    
    public Page<analisisModel> getAnalisisByEstado(String estado, Pageable pageable) {
        return analisisRepository.findByEstado(estado, pageable);
    }

    public List<analisisModel> getAnalisisByTipoAnalisis(String tipo) {
        return analisisRepository.findByTipo(tipo);
    }

    //implementamos un algoritmo de búsqueda binaria para encontrar rápidamente un análisis por su ID,
    // y un algoritmo de ordenamiento por fecha de análisis:
    private List<analisisModel> analisisList = new ArrayList<>();

    // Método para agregar análisis
    public void agregarAnalisis(analisisModel analisis) {
        analisisList.add(analisis);
        ordenarAnalisisPorId();
    }

    // Método para ordenar la lista de análisis por ID
    private void ordenarAnalisisPorId() {
        Collections.sort(analisisList, Comparator.comparing(analisisModel::getId));
    }

    // Método de búsqueda binaria para encontrar un análisis por ID
    //public analisisModel buscarAnalisisPorId(String id) {
    //    int index = Collections.binarySearch(analisisList, new analisisModel(id), Comparator.comparing(analisisModel::getId));
    //    return index >= 0 ? analisisList.get(index) : null;
    //}

    // Método para ordenar la lista de análisis por fecha
    public void ordenarAnalisisPorFecha() {
        Collections.sort(analisisList, Comparator.comparing(analisisModel::getFechaRecoleccion));
    }
    analisisModel analisis = new analisisModel();
    
    // Método para ordenar la lista de análisis por fecha usando QuickSort
    public void ordenarAnalisisPorFechaQuickSort() {
        quickSort(analisisList, 0, analisisList.size() - 1);
    }

    private void quickSort(List<analisisModel> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);

            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private int partition(List<analisisModel> list, int low, int high) {
        analisisModel pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j).getFechaRecoleccion().compareTo(pivot.getFechaRecoleccion()) <= 0) {
                i++;

                // Swap list[i] and list[j]
                analisisModel temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        // Swap list[i + 1] and list[high] (or pivot)
        analisisModel temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
    
}
