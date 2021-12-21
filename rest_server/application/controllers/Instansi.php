<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
class Instansi extends REST_Controller {
	function __construct($config = 'rest') {
		parent::__construct($config);
		$this->load->database();
	}
 //Menampilkan data instansi
	function index_get() {
		$id = $this->get('id');
		if ($id == '') {
			$instansi = $this->db->get('instansi')->result();
		} else {
			$this->db->where('id', $id);
			$instansi = $this->db->get('instansi')->result();
		}
		$this->response($instansi, 200);
	}
 //Masukan function selanjutnya disini

//Mengirim atau menambah data instansi baru
	function index_post() {
		$data = array(
			'id' => $this->post('id'),
			'instansi' => $this->post('instansi'),
			'telepon' => $this->post('telepon'));
		$insert = $this->db->insert('instansi', $data);
		if ($insert) {
			$this->response($data, 200);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}
//Masukan function selanjutnya disini
//Memperbarui data instansi yang telah ada
	function index_put() {
		$id = $this->put('id');
		$data = array(
			'id' => $this->put('id'),
			'instansi' => $this->put('instansi'),
			'telepon' => $this->put('telepon'));
		$this->db->where('id', $id);
		$update = $this->db->update('instansi', $data);
		if ($update) {
			$this->response($data, 200);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}
//Masukan function selanjutnya disini

//Menghapus salah satu data instansi
	function index_delete() {
		$id = $this->delete('id');
		$this->db->where('id', $id);
		$delete = $this->db->delete('instansi');
		if ($delete) {
			$this->response(array('status' => 'success'), 201);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}

}

?>