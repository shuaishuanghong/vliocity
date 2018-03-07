/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */

package jp.co.realsys.model;

/**
 * �w��Model�N���X
 * 
 * @author Realsys
 */
public class StudentModel {

	/** ID */
	private String	id;
	/** ���O */
	private String	name;
	/** ���N���� */
	private String	birthDate;

    public StudentModel() {
    }

    public StudentModel(String id, String name, String birthDate, String address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    /** �Z�� */

	private String	address;

	/**
	 * ID���擾����B
	 * 
	 * @return
	 */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * ���N�������擾����B
     * 
     * @return
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * 
     * @param birthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ID���擾����B
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", address=" + address + "]";
	}



}

