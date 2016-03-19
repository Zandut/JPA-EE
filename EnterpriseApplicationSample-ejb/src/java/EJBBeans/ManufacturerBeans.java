/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBBeans;

import entityClasses.Manufacturer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ZANDUT
 */
@Stateless

public class ManufacturerBeans
{

    @PersistenceContext(unitName = "EnterpriseApplicationSample-ejbPU")
    private EntityManager em;

    public EntityManager getEntityManager()
    {
        return em;
    }

    public void create(Manufacturer manufacturer)
    {
        em.persist(manufacturer);
    }

    public void destroy(Manufacturer manufacturer)
    {
        em.remove(em.merge(manufacturer));

    }

    public Manufacturer findManufacturer(Integer id)
    {
        EntityManager em = getEntityManager();

        Query q = em.createNamedQuery("Manufacturer.findByManufacturerId");
        q.setParameter("manufacturerId", id);

        return (Manufacturer) q.getSingleResult();

    }

    public List<Manufacturer> findManufacturerAll()
    {
        EntityManager em = getEntityManager();

        Query q = em.createNamedQuery("Manufacturer.findAll");

        return q.getResultList();

    }

}
