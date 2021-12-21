<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
class Alamat extends REST_Controller {
	function __construct($config = 'rest') {
		parent::__construct($config);
		$this->load->database();
	}
 //Menampilkan data alamat
	function index_get() {
		$id = $this->get('id');
		if ($id == '') {
			$alamat = $this->db->get('alamat')->result();
		} else {
			$this->db->where('id', $id);
			$alamat = $this->db->get('alamat')->result();
		}
		$this->response($alamat, 200);
	}
 //Masukan function selanjutnya disini

//Mengirim atau menambah data alamat baru
	function index_post() {
		$data = array(
			'id' => $this->post('id'),
			'alamat' => $this->post('alamat'),
			'kodepos' => $this->post('kodepos'));
		$insert = $this->db->insert('alamat', $data);
		if ($insert) {
			$this->response($data, 200);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}
//Masukan function selanjutnya disini
//Memperbarui data alamat yang telah ada
	function index_put() {
		$id = $this->put('id');
		$data = array(
			'id' => $this->put('id'),
			'alamat' => $this->put('alamat'),
			'kodepos' => $this->put('kodepos'));
		$this->db->where('id', $id);
		$update = $this->db->update('alamat', $data);
		if ($update) {
			$this->response($data, 200);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}
//Masukan function selanjutnya disini

//Menghapus salah satu data alamat
	function index_delete() {
		$id = $this->delete('id');
		$this->db->where('id', $id);
		$delete = $this->db->delete('alamat');
		if ($delete) {
			$this->response(array('status' => 'success'), 201);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}

}

?>