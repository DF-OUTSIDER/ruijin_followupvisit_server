package application.service.impl;

import application.domain.RoleDto;
import application.repository.RoleRepository;
import application.service.RoleOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
public class RoleOperationImpl implements RoleOperationService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public boolean roleCanAccessUri(List<String> researchRoles, String uri) {
        if (uri.startsWith("/"))
            uri = uri.substring(1);

        Stream<RoleDto> uriRoles = roleRepository.findUriRoles(uri)
                .map(roleEntity -> new RoleDto(roleEntity.getRoleId(), roleEntity.getRoleName()));

        return uriRoles.anyMatch(ur -> researchRoles.stream().anyMatch(researchRole -> researchRole.contentEquals(ur.getRoleName())));
    }
}
