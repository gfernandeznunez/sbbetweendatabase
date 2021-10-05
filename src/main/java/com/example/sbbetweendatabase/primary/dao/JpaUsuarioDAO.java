package com.example.sbbetweendatabase.primary.dao;

import com.example.sbbetweendatabase.primary.model.InputUsuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaUsuarioDAO implements UsuarioDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<InputUsuario> findAll() {
       /*
        return em.createQuery(
                "Select distinct top 1000 a.usrcode codigo_usuario, a.usrTaxID rut, usrFirstName, a.usrLastName From \n" +
                        " DCCPPlatform.dbo.gbluser a, DCCPPlatform.dbo.gblSecUserRole b, DCCPPlatform.dbo.gblOrganization c, " +
                        " DCCPPlatform.dbo.gblenterprise d, DCCPPlatform.dbo.gblSecRole e\n" +
                        " where \n" +
                        " a.usrCode = b.uroUser\n" +
                        " and c.orgCode = b.uroOrganization\n" +
                        " and c.orgClass = 2  ---Comprador\n" +
                        " and d.entcode = c.orgenterprise\n" +
                        " and a.usrIsActive = 1 ---Activo\n" +
                        " and b.urorole = e.rolCode;", Usuario.class).getResultList();

        */
        return em.createQuery("select a from usuario a", InputUsuario.class).getResultList();
    }
}
