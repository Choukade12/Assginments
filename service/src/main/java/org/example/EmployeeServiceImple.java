package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class EmployeeServiceImple implements EmployeeService{
    private HashMap<UUID, Employee> map = new HashMap<>();

    @Override
    public Employee create(Employee emp) {
        UUID id = UUID.randomUUID();
        emp.setEmpId(id);
        map.put(id, emp);
        return emp;
    }

    @Override
    public Employee read(UUID id) {
        if(findById(id)){
            return map.get(id);
        }
        else return null;
    }

    @Override
    public boolean findById(UUID id) {
        if(map.containsKey(id)) return true;
        else return false;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>(map.values());
        return list;
    }
}
